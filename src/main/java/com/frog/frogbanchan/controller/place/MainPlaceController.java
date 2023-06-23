package com.frog.frogbanchan.controller.place;

import com.frog.frogbanchan.controller.PlaceSession;
import com.frog.frogbanchan.domain.Place;
import com.frog.frogbanchan.domain.Reservation;
import com.frog.frogbanchan.service.FrogBanchanFacade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPlaceController {

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    @RequestMapping("/place/main")
    public ModelAndView handleRequest1(@SessionAttribute("placeSession") PlaceSession placeSession)
            throws Exception {
        ModelAndView mav = new ModelAndView("/place/mainForPlace");

        Place place = placeSession.getPlace();
        mav.addObject("place", place);

        String placeId = placeSession.getPlace().getPlaceId();
        List<Reservation> reservationList = frogBanchan.findReservationByPlaceId(placeId);

        List<String> reservationTime = new ArrayList<String>();
        List<String> reservationName = new ArrayList<String>();
        List<Integer> reservationSeat = new ArrayList<Integer>();

        Calendar cal = java.util.Calendar.getInstance();
        String currentYear = String.valueOf(cal.get(java.util.Calendar.YEAR));
        String currentMonth = String.valueOf(cal.get(java.util.Calendar.MONTH) + 1);
        String currentDate = String.valueOf(cal.get(java.util.Calendar.DATE));
        for (Reservation reservation : reservationList) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String revDate = format.format(reservation.getReservationDate());
            System.out.println("************************revDate" + revDate);
            if ((currentYear + "-0" + currentMonth + "-" + currentDate).equals(revDate)) {
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH");
                reservationTime.add(timeFormat.format(reservation.getReservationDate()));
                reservationName.add(reservation.getUsername());
                reservationSeat.add(reservation.getSeat());
            }
            System.out
                    .println("************************today" + (currentYear + "-" + currentMonth + "-" + currentDate));
        }

        System.out.println("************************" + reservationList);
        mav.addObject("currentYear", currentYear);
        mav.addObject("currentMonth", currentMonth);
        mav.addObject("currentDate", currentDate);
        mav.addObject("reservationTimeList", reservationTime);
        mav.addObject("reservationNameList", reservationName);
        mav.addObject("reservationSeatList", reservationSeat);

        return mav;
    }

    @RequestMapping("/place/myPage")
    public ModelAndView handleMyPage(@SessionAttribute("placeSession") PlaceSession placeSession)
            throws Exception {
        ModelAndView mav = new ModelAndView("/place/myPageForPlace");

        Place place = placeSession.getPlace();
        mav.addObject("place", place);

        return mav;
    }

    @RequestMapping("/place/view")
    public ModelAndView handleView(@RequestParam("placeId") String placeId)
            throws Exception {
        ModelAndView mav = new ModelAndView("/place/placeDetail");

        mav.addObject("place", frogBanchan.findPlaceById(placeId));
        mav.addObject("menuList", frogBanchan.findMenuListByPlaceId(placeId));

        return mav;
    }

    @RequestMapping("/place/list")
    public String handleRequest4(Model model) throws Exception {
        model.addAttribute("placeList", frogBanchan.findAllPlaceList());

        return "/place/placeList";
    }

}
