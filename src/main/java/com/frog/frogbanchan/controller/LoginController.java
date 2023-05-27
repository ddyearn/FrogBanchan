package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.domain.Place;
import com.frog.frogbanchan.domain.Users;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes({"userSession", "placeSession"})
@RequestMapping("/login")
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
	public ModelAndView handleRequest(HttpServletRequest request,
									   @RequestParam("id") String id,
									   @RequestParam("password") String password,
									   @RequestParam(value = "forwardAction", required = false) String forwardAction,
									   Model model) throws Exception {

		Users users = frogBanchan.findUserByUsername(id);
		Place place = frogBanchan.findPlaceById(id);
		System.out.println(users);
		System.out.println(place);

		String viewName;
		if (users != null && password.equals(users.getPassword())) {
			UserSession userSession = new UserSession(users);
			model.addAttribute("userSession", userSession);
			viewName = "/user/mainForCommon";
		} else if (place != null && password.equals(place.getPassword())) {
			PlaceSession placeSession = new PlaceSession(place);
			model.addAttribute("placeSession", placeSession);
			viewName = "/place/mainForPlace";
		} else {
			String errorMsg;
			if (users == null && place == null) {
				errorMsg = "아이디가 존재하지 않구리";
			} else {
				errorMsg = "비밀번호를 확인하구리";
			}
			viewName = "login";
			model.addAttribute("errorMsg", errorMsg);
			return new ModelAndView(viewName);
		}

		if (forwardAction != null) {
			return new ModelAndView("redirect:" + forwardAction);
		} else {
			return new ModelAndView(viewName);
		}
	}

	/*
	@RequestMapping("/index")
	public String handler() {
		return "th/index";
	}

	@RequestMapping("/index/th")
	public String handler3() {
		return "th/test";
	}
	*/
}
