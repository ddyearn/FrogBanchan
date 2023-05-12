package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.service.FrogBanchanImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@Autowired
	private FrogBanchanImpl frogBanchan;

	@RequestMapping("/")
	public String handler() {
		System.out.println(frogBanchan.findMembersByNickname("나메코"));
		System.out.println(frogBanchan.findUsernameList());
		return "index";
	}
	
}
