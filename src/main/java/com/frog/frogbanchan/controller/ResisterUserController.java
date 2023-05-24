package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.service.FrogBanchanFacade;
import com.frog.frogbanchan.service.FrogBanchanImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/register")
public class ResisterUserController {

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    @GetMapping
    public String form() {
        return "/user/userForm";
    }

}
