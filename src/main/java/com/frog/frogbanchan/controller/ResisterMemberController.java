package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.service.FrogBanchanImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class ResisterMemberController {

    @Autowired
    private FrogBanchanImpl frogBanchan;

    @GetMapping
    public String form() {
        return "/member/memberForm";
    }

}
