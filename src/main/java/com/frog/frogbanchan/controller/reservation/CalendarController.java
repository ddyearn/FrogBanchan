package com.frog.frogbanchan.controller.reservation;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.frog.frogbanchan.controller.PlaceSession;
import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.domain.Reservation;
import com.frog.frogbanchan.service.FrogBanchanFacade;

@Controller
public class CalendarController {

    @Value("/reservation/calendarForPlace")
    private String CALENDAR_FORPLACE;

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    @RequestMapping("/reservation/calendar")
    public ModelAndView handleRequest(HttpServletRequest request,
            ModelMap model, String placeId) throws Exception {

        model.addAttribute("placeId", "toritori");
        List<Timestamp> availableTimeList = frogBanchan.findCalendar("toritori");
        System.out.println("testest" + availableTimeList);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");

        String[] days = new String[100];
        int i = 0;
        for (Timestamp timestamp : availableTimeList) {
            String date = dateFormat.format(timestamp);
            String month = monthFormat.format(timestamp);
            String day = dayFormat.format(timestamp);
            days[i++] = day;

            System.out.println("Date: " + date);
            System.out.println("Month: " + month);
            System.out.println("Day: " + day);
            System.out.println("---------");
        }
        ModelAndView mav = new ModelAndView("/reservation/calendar");
        mav.addObject("days", days);

        return mav;
    }

    @GetMapping("/reservation/calendar/forplace")
    public ModelAndView handleRequestForBusiness(HttpServletRequest request, ModelMap model,
            @SessionAttribute("placeSession") PlaceSession placeSession) throws Exception {
        List<Timestamp> availableTimeList = frogBanchan.findCalendar(placeSession.getPlace().getPlaceId());

        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");

        String[] availableDays = new String[100];
        int i = 0;
        for (Timestamp timestamp : availableTimeList) {
            String day = dayFormat.format(timestamp);
            availableDays[i++] = day;
        }
        System.out.println("availableDays: " + availableDays);
        System.out.println("---------");

        List<Reservation> reservationList = frogBanchan.findReservationByPlaceId(placeSession.getPlace().getPlaceId());
        List<Timestamp> reservedTimeList = new ArrayList<>();
        for (Reservation resv : reservationList) {
            reservedTimeList.add(resv.getReservationDate());
        }

        String[] reservedDays = new String[100];
        i = 0;
        for (Timestamp timestamp : reservedTimeList) {
            String day = dayFormat.format(timestamp);
            reservedDays[i++] = day;
        }
        System.out.println("reservedDays: " + reservedDays);
        System.out.println("---------");

        String[] selectedDays = new String[100];

        ModelAndView mav = new ModelAndView("/reservation/calendarForPlace");
        model.addAttribute("placename", placeSession.getPlace().getName());
        mav.addObject("availableDays", availableDays);
        mav.addObject("reservedDays", reservedDays);
        // mav.addObject("selectedDays", selectedDays);

        return mav;
    }

    @PostMapping("/reservation/calendar/forplace")
    public String handleRequestForBusiness2(HttpServletRequest request, ModelMap model,
            @SessionAttribute("placeSession") PlaceSession placeSession,
            @RequestParam Object selectedDay, @RequestParam String selectedTime, @RequestParam String flag)
            throws Exception {

        System.out.print(flag + "*******flag");
        if (flag.equals("none")) {
            Calendar calendar = Calendar.getInstance();
            int currentYear = calendar.get(Calendar.YEAR);
            int currentMonth = calendar.get(Calendar.MONTH) + 1;

            String dateTimeString = String.format("%04d-%02d-%s %s", currentYear, currentMonth, selectedDay,
                    selectedTime);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            java.util.Date parsedDate = null;
            try {
                parsedDate = dateFormat.parse(dateTimeString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            System.out.print(parsedDate + "************parsedDAte");
            Timestamp timestamp = new Timestamp(parsedDate.getTime());

            frogBanchan.insertAvailableTime(placeSession.getPlace().getPlaceId(), timestamp);
        }

        // get 메소드랑 아래 내용 같음
        List<Timestamp> availableTimeList = frogBanchan.findCalendar(placeSession.getPlace().getPlaceId());

        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        
        String[] availableDays = new String[100];
        int i = 0;
        for (Timestamp timestamp : availableTimeList) {
            String day = dayFormat.format(timestamp);
            availableDays[i++] = day;
        }
        System.out.println("availableDays: " + availableDays);
        System.out.println("---------");

        List<Reservation> reservationList = frogBanchan.findReservationByPlaceId(placeSession.getPlace().getPlaceId());
        List<Timestamp> reservedTimeList = new ArrayList<>();
        for (Reservation resv : reservationList) {
            reservedTimeList.add(resv.getReservationDate());
        }

        String[] reservedDays = new String[100];
        i = 0;
        for (Timestamp timestamp : reservedTimeList) {
            String day = dayFormat.format(timestamp);
            reservedDays[i++] = day;
        }
        System.out.println("reservedDays: " + reservedDays);
        System.out.println("---------");

        model.addAttribute("placename", placeSession.getPlace().getName());
        model.addAttribute("availableDays", availableDays);
        model.addAttribute("reservedDays", reservedDays);
        return CALENDAR_FORPLACE;

    }

}
