package com.frog.frogbanchan.controller.reservation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
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

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    @PostMapping("/reservation/time")
    public String timeselectHandle(ModelMap modelMap, @ModelAttribute String placeId, String selectedDay) {
        List<Timestamp> reservedTimeList = frogBanchan.findReservedTime(placeId);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH");

        String[] times = new String[9];
        int i = 0;
        for (Timestamp timestamp : reservedTimeList) {
            String time = timeFormat.format(timestamp);

            times[i++] = time;

            System.out.println("time: " + time);
            System.out.println("---------");
        }

        modelMap.addAttribute("reservatedTimes", times);
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
}
