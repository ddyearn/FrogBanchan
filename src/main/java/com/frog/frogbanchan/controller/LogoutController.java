package com.frog.frogbanchan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String handleRequest(HttpSession session) throws Exception {
        session.removeAttribute("userSession");
        session.removeAttribute("placeSession");
        session.invalidate();
        return "login";
    }

}
