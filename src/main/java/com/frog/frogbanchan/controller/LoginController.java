package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.domain.Users;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/user/login")
public class LoginController {

	private FrogBanchanFacade frogBanchan;

	@Autowired
	public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
		this.frogBanchan = frogBanchan;
	}

	@GetMapping
	public String form() {
		return "login";
	}

	@PostMapping
	public ModelAndView handleRequest1(HttpServletRequest request,
									   @RequestParam("username") String username,
									   @RequestParam("password") String password,
									   @RequestParam(value = "forwardAction", required = false) String forwardAction,
									   Model model) throws Exception {
		Users user = frogBanchan.findUserByUsername(username);
		if (user == null || !password.equals(user.getPassword())) {
			return new ModelAndView("login");
		} else {
			UserSession userSession = new UserSession(user);
			model.addAttribute("userSession", userSession);
			if (forwardAction != null) {
				return new ModelAndView("redirect:" + forwardAction);
			} else {
				return new ModelAndView("index");
			}
		}
	}

	/*
	@RequestMapping("/index")
	public String handler() {
		return "th/index";
	}

//	@RequestMapping("/index/th")
//	public String handler3() {
//		return "th/test";
//	}

	@RequestMapping("/index/login")
	public String handler2() {
		return "login";
	}
	*/
}
