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
			@ModelAttribute("team") Team team) throws Exception {
		List<Users> memberList = frogBanchan.findTeamMembers(team.getTeamId());
		for (Users mem : memberList) {
			if (mem.getUsername() == username) 
				return new ModelAndView("Team", "team", team);
		}
		
		frogBanchan.addTeamMember(team.getTeamId(), username);
	
		return new ModelAndView("Team", "team", team);
	}
	
	@RequestMapping("/team/deleteTeamMember")
	public ModelAndView deleteTeamMember(
			@RequestParam("username") String username,
			@ModelAttribute("team") Team team
		) throws Exception {
		frogBanchan.deleteTeamMember(team.getTeamId(), username);
		
		return new ModelAndView("Team", "team", team);
	}
}