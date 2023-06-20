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
public class ReservationContorller {

    @Value("/reservation/timeSelect")
    private String TIME_SELECT_VIEW;
    @Value("/reservation/reservationForm")
    private String FORM_VIEW;
    @Value("/reservation/reservationResult")
    private String RESULT_VIEW;
    @Value("/reservation/timeSelectForPlace")
    private String TIME_SELECT_VIEW_FORPLACE;
    @Value("/reservation/reservationResultForPlace")
    private String RESULT_VIEW_FORPLACE;
    @Value("/reservation/calendarForPlace")
    private String CALENDAR_FORPLACE;

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    @RequestMapping("/reservation/time")
    public String timeselectHandle(ModelMap modelMap, @ModelAttribute String placeId, String selectedDay) {
        List<Timestamp> reservedTimeList = frogBanchan.findReservedTime("toritori"); // placeId 사용
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH");

        String[] times = new String[9];
        int i = 0;
        for (Timestamp timestamp : reservedTimeList) {
            String time = timeFormat.format(timestamp);

            times[i++] = time;

            System.out.println("time: " + time + "placeId" + placeId);
            System.out.println("---------");
        }

        modelMap.addAttribute("times", times);
        modelMap.addAttribute("selectedDay", selectedDay);
        return TIME_SELECT_VIEW;
    }

    @PostMapping("/reservation/user")
    public String showForm(ModelMap modelMap, String selectedDay, String selectedTime) {

        modelMap.addAttribute("selectedDay", selectedDay);
        modelMap.addAttribute("selectedTime", selectedTime);
        return FORM_VIEW;
    }

    @PostMapping("/reservation/result")
    public String handleResult(ModelMap modelMap, String selectedDay, String selectedTime, int numReservations,
            @SessionAttribute("userSession") UserSession userSession, @ModelAttribute String placeId) {

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

    // FOR PLACE
    @RequestMapping("/reservation/time/forplace") // requestparam으로 input 태그 받기
    public String timeselectHandleForPlace(HttpServletRequest request, ModelMap modelMap,
            @SessionAttribute("placeSession") PlaceSession placeSession,
            @RequestParam("selectedDay") Object selectedDay) {
        List<Timestamp> reservedTimeList = frogBanchan.findReservedTime(placeSession.getPlace().getPlaceId()); // placeId 사용
        List<Timestamp> availableTimeList = frogBanchan.findCalendar(placeSession.getPlace().getPlaceId()); // placeId 사용
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH");

        String[] availableTime = new String[100];
        int i = 0;
        for (Timestamp timestamp : availableTimeList) {
            Date date = new Date(timestamp.getTime());

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
            // Format the Date object to the desired date and time format
            String formattedDate = dateFormat.format(date);
            if(formattedDate.equals(selectedDay)){
                String day = timeFormat.format(timestamp);
                availableTime[i++] = day;

                System.out.println("availableTimes: " + availableTime);
                System.out.println("---------");
            }
            
        }

        String[] reservedTimes = new String[100];
        i = 0;
        for (Timestamp timestamp : reservedTimeList) {
                Date date = new Date(timestamp.getTime());

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd");

                // Format the Date object to the desired date and time format
                String formattedDate = dateFormat.format(date);
                if(formattedDate.equals(selectedDay)){
                    String time = timeFormat.format(timestamp);

                    reservedTimes[i++] = time;
                }
        }

        modelMap.addAttribute("availableTimes", availableTime);
        modelMap.addAttribute("reservedTimes", reservedTimes);
        modelMap.addAttribute("selectedDay", selectedDay);

        return TIME_SELECT_VIEW_FORPLACE;
    }

    @RequestMapping("/reservation/result/forplace") // requestparam으로 input 태그 받기
    public String resultHandleForPlace(HttpServletRequest request, ModelMap modelMap,
            @SessionAttribute("placeSession") PlaceSession placeSession,
            @RequestParam("selectedDay") String selectedDay,
            @RequestParam("selectedTime") String selectedTime, @RequestParam("flag") String flag) {

        System.out.print(flag + "******************flag");
        String reservedDay = null;
        String reservedTime = null;
        String username = null;
        int seat = 0;

        if (flag.equals("reservation")) {
            List<Reservation> reservations = frogBanchan.findReservationByPlaceId(placeSession.getPlace().getPlaceId());
            for (Reservation reservation : reservations) {
                Timestamp timestamp = reservation.getReservationDate();

                Date date = new Date(timestamp.getTime());

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH");

                // Format the Date object to the desired date and time format
                String formattedDate = dateFormat.format(date);
                String formattedTime = timeFormat.format(date);

                if (formattedDate.equals(selectedDay) && selectedTime.contains(formattedTime)) {
                    reservedDay = formattedDate;
                    reservedTime = formattedTime;
                    username = reservation.getUsername();
                    seat = reservation.getSeat();
                }
            }
        }

        modelMap.addAttribute("reservedDay", reservedDay);
        modelMap.addAttribute("reservedTime", reservedTime);
        modelMap.addAttribute("username", username);
        modelMap.addAttribute("seat", seat);

        return RESULT_VIEW_FORPLACE;
    }
}
