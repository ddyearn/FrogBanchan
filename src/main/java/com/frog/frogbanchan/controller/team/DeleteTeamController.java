package com.frog.frogbanchan.controller.team;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.frog.frogbanchan.domain.Team;
import com.frog.frogbanchan.service.FrogBanchanFacade;

@Controller
public class DeleteTeamController { 

	private FrogBanchanFacade frogBanchan;

	@Autowired
	public void setFrogbanchan(FrogBanchanFacade frogBanchan) {
		this.frogBanchan = frogBanchan;
	}

	@RequestMapping("/team/delete.do")
	public String handleRequest(
			@RequestParam("teamId") int teamId, 
			ModelMap model) throws Exception {
		frogBanchan.deleteTeam(teamId);
		
		return "/user/mainForCommon";
	}

}