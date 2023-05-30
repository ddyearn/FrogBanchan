package com.frog.frogbanchan.controller.team;

import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.domain.Team;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import com.frog.frogbanchan.service.FrogBanchanImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frog.frogbanchan.validator.TeamFormValidator;
import org.springframework.beans.factory.annotation.Value;

@Controller
@RequestMapping("/team/create")
public class TeamFormController {
	@Value("/team/teamForm")
	private String FORM_VIEW;
	@Value("/team/view")
	private String RESULT_VIEW;

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

	@ModelAttribute("teamForm")
    public TeamForm createTeamForm() {
        return new TeamForm();
    }
	
	@Autowired
    private TeamFormValidator validator;
    public void setValidator(TeamFormValidator validator) {
        this.validator = validator;
    }
    
	@GetMapping
    public String showForm() {
        return FORM_VIEW;
    }
	
	@PostMapping
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("teamForm") TeamForm teamForm, BindingResult bindingResult, Model model) throws Exception {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		
		validator.validate(teamForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return FORM_VIEW;
		}
		
		String creator = userSession.getUser().getUsername();
		Team team = teamForm.getTeam();
		team.setCreator(creator);
        
		frogBanchan.insertTeam(team);
		model.addAttribute("team", team);
		
		return RESULT_VIEW;
	}
	
}
