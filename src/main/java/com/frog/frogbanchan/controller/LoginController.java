package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.service.FrogBanchanImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private FrogBanchanImpl frogBanchan;

	@RequestMapping("/index")
	public String handler() {
		return "th/index";
	}

	@RequestMapping("/index/th")
	public String handler3() {
		return "th/test";
	}

	@RequestMapping("/index/login")
	public String handler2() {
		return "login";
	}
	
}
