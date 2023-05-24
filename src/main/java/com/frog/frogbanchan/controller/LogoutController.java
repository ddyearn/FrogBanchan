package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.service.FrogBanchanImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @Autowired
    private FrogBanchanImpl frogBanchan;

    @RequestMapping("/user/logout")
    public String handleRequest(HttpSession session) throws Exception {
        session.removeAttribute("userSession");
        session.invalidate();
        return "login";
    }

}
