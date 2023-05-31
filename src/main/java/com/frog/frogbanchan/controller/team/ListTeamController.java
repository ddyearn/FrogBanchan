package com.frog.frogbanchan.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.service.FrogBanchanFacade;

@Controller
@SessionAttributes("userSession")
public class ListTeamController { 

	private FrogBanchanFacade frogbanchan;

	@Autowired
	public void setFrogbanchan(FrogBanchanFacade frogbanchan) {
		this.frogbanchan = frogbanchan;
	}

	@RequestMapping("/team/list")
	public ModelAndView handleRequest(
			@ModelAttribute("userSession") UserSession userSession) throws Exception {
		String username = userSession.getUser().getUsername();
		
		return new ModelAndView("/team/list", "teamList", frogbanchan.findTeamList(username));
	}
}