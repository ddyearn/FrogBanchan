package com.frog.frogbanchan.controller.team;

import com.frog.frogbanchan.domain.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.frog.frogbanchan.service.ParticipationService;

@Controller
public class TeamMemberController { 

	private ParticipationService participationService;
	@Autowired
	public void setParticipationService(ParticipationService participationService) {
        this.participationService = participationService;
    }

	@RequestMapping("/team/addTeamMember")
	public ModelAndView addTeamMember(
			@RequestParam("username") String username,
			@RequestParam("email") String email,
			@RequestParam("teamId") int teamId) throws Exception {

		ModelAndView mav = new ModelAndView("redirect:/team/main/" + teamId);
		Team team = participationService.getParticipation(username, email, teamId);
		mav.addObject("team", team);

		return mav;
	}
	
	@RequestMapping("/team/quitTeamMember")
	public String quitTeam(@RequestParam("teamId") int teamId, @RequestParam("username") String username) throws Exception {
		participationService.quitParticipation(teamId, username);
		
		return "redirect:/user/main";
	}
	
	@RequestMapping("/team/deleteTeamMember")
	public String deleteTeamMember(
			@RequestParam("username") String username,
			@RequestParam("teamId") int teamId
		) throws Exception {
		participationService.outParticipation(teamId, username);
		
		return "redirect:/team/main/" + teamId;
	}
}