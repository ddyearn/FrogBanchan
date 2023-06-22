package com.frog.frogbanchan.controller.reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.util.WebUtils;

import com.frog.frogbanchan.controller.PlaceSession;
import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.domain.Reservation;
import com.frog.frogbanchan.service.FrogBanchanFacade;

@Controller
public class ReservationController {

    @Value("/reservation/timeSelect")
    private String TIME_SELECT_VIEW;
    @Value("/reservation/reservationForm")
    private String FORM_VIEW;
    @Value("/reservation/reservationResult")
    private String RESULT_VIEW;
    @Value("/reservation/check")
    private String RESERVATION_CHECK_VIEW;

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    @RequestMapping("/reservation/time")
    public String timeselectHandle(ModelMap modelMap, @RequestParam("placeId") String placeId,
            @RequestParam String selectedDay) {
        List<Timestamp> reservedTimeList = frogBanchan.findReservedTime(placeId); // placeId 사용
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH");

        String[] reservedTimes = new String[100];
        int i = 0;
        for (Timestamp timestamp : reservedTimeList) {
            Date date = new Date(timestamp.getTime());

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd");

            // Format the Date object to the desired date and time format
            String formattedDate = dateFormat.format(date);
            if (formattedDate.equals(selectedDay)) {
                String time = timeFormat.format(timestamp);

                reservedTimes[i++] = time;
            }
        }
        modelMap.addAttribute("placeId", placeId);
        modelMap.addAttribute("reservedTimes", reservedTimes);
        modelMap.addAttribute("selectedDay", selectedDay);

        return TIME_SELECT_VIEW;
    }

    @PostMapping("/reservation/form")
    public String showForm(ModelMap modelMap, @RequestParam("placeId") String placeId, @RequestParam String selectedDay,
            @RequestParam String selectedTime) {

        modelMap.addAttribute("placeId", placeId);
        modelMap.addAttribute("selectedDay", selectedDay);
        modelMap.addAttribute("selectedTime", selectedTime);
        return FORM_VIEW;
    }

    @PostMapping("/reservation/result")
    public String handleResult(ModelMap modelMap, @RequestParam("placeId") String placeId,
            @RequestParam String selectedDay, @RequestParam String selectedTime, @RequestParam int numReservations,
            @SessionAttribute("userSession") UserSession userSession) {

        modelMap.addAttribute("placeId", placeId);
        modelMap.addAttribute("selectedDay", selectedDay);
        modelMap.addAttribute("selectedTime", selectedTime);
        modelMap.addAttribute("selectedPeople", numReservations);

        try {
            Calendar calendar = Calendar.getInstance();
            int currentYear = calendar.get(Calendar.YEAR);
            int currentMonth = calendar.get(Calendar.MONTH) + 1; // Month is zero-based, so adding 1

            // Convert selectedDay and selectedTime to Timestamp
            String dateTimeString = String.format("%04d-%02d-%s %s", currentYear, currentMonth, selectedDay,
                    selectedTime);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            java.util.Date parsedDate = dateFormat.parse(dateTimeString);
            Timestamp timestamp = new Timestamp(parsedDate.getTime());

            System.out.println(userSession.getUser().getUsername() + placeId + timestamp + numReservations);
            Reservation reservation = new Reservation(userSession.getUser().getUsername(), "toritori", timestamp,
                    numReservations);
            frogBanchan.insertReservation(reservation);
            System.out.println(reservation);

            return RESULT_VIEW;
        } catch (Exception e) {
            // Handle any parsing or conversion errors
            e.printStackTrace();
            return "error-page";
        }
    }

    @GetMapping("/reservation/check")
    public String handleCheck(ModelMap modelMap, @RequestParam("placeId") String placeId,
            @RequestParam String reservationId,
            @SessionAttribute("userSession") UserSession userSession) {

        // reservationId를 갖고와서 해당 reservation을 건네줘야함
        List<Reservation> reservation = null;
        try {
            reservation = frogBanchan.findReservationByReservationId(reservationId);
        } catch (Exception e) {
            // Handle any parsing or conversion errors
            e.printStackTrace();
            return "error-page";
        }

        Timestamp date = reservation.get(0).getReservationDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(date);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String formattedTime = timeFormat.format(date);

        modelMap.addAttribute("placeId", placeId);
        modelMap.addAttribute("date", formattedDate);
        modelMap.addAttribute("time", formattedTime);
        modelMap.addAttribute("seat", reservation.get(0).getSeat());

        return RESERVATION_CHECK_VIEW;
    }

    @PostMapping("/reservation/check")
    public String handleDeleteReservation(ModelMap modelMap, @RequestParam("placeId") String placeId,
            @RequestParam String reservationId,
            @SessionAttribute("userSession") UserSession userSession) {

        int rsvid = Integer.parseInt(reservationId);

        try {
            frogBanchan.deleteReservation(rsvid);
        } catch (Exception e) {
            // Handle any parsing or conversion errors
            e.printStackTrace();
            return "error-page";
        }

        // 예약 확인 페이지로 return 해야함
        return "";
    }
}
