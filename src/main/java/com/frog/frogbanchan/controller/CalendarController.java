package com.frog.frogbanchan.controller;

import java.sql.Timestamp;
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

        return new ModelAndView("calendar").addObject("calendar", frogBanchan.findCalendar("toritori"));
    }

}
