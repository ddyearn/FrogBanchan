package com.frog.frogbanchan.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.frog.frogbanchan.service.FrogBanchanFacade;

@Controller
@RequestMapping("/place/calendar")
public class CalendarController {

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    public ModelAndView handleRequest(HttpServletRequest request,
            Model model) throws Exception {

        List<Timestamp> availableTimeList = frogBanchan.findCalendar("toritori");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");

        String[] days = null;
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

        return new ModelAndView("calendar").addObject("days", days);
    }

}
