package com.frog.frogbanchan.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.frog.frogbanchan.service.ParticipationService;

@Controller
public class DeleteTeamController { 

	private ParticipationService participationService;
	@Autowired
	public void setParticipationService(ParticipationService participationService) {
        this.participationService = participationService;
    }

	@RequestMapping("/team/delete")
	public String handleRequest(
			@RequestParam("teamId") int teamId, 
			ModelMap model) throws Exception {
		participationService.deleteTeam(teamId);
		
		return "redirect:/user/main";
	}

}