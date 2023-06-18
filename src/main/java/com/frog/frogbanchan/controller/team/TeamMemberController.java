package com.frog.frogbanchan.controller.team;

import java.util.List;

import com.frog.frogbanchan.domain.Team;
import com.frog.frogbanchan.domain.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.frog.frogbanchan.service.FrogBanchanFacade;

@Controller
public class TeamMemberController { 

	private FrogBanchanFacade frogBanchan;
    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

	@RequestMapping("/team/addTeamMember")
	public ModelAndView addTeamMember(
			@RequestParam("username") String username,
			@RequestParam("email") String email,
			@RequestParam("teamId") int teamId) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/team/main/" + teamId);
		mav.addObject("team", frogBanchan.findTeam(teamId));

		Users user = frogBanchan.findUserByUsername(username);
		if (user != null && email.equals(user.getEmail())) {
			boolean isParticipated = false;
			List<Users> memberList = frogBanchan.findTeamMembers(teamId);
			for (Users mem : memberList) {
				if (username.equals(mem.getUsername())) {
					isParticipated = true;
					break;
				}
			}
			if (!isParticipated) {
				frogBanchan.addTeamMember(teamId, username);
			}
		}
	
		return mav;
	}
	
	@RequestMapping("/team/deleteTeamMember")
	public ModelAndView deleteTeamMember(
			@RequestParam("username") String username,
			@ModelAttribute("team") Team team
		) throws Exception {
		frogBanchan.deleteTeamMember(team.getTeamId(), username);
		
		return new ModelAndView("/team/teamPage", "team", team);
	}
}