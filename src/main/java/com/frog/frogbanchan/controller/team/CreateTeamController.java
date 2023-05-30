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
public class CreateTeamController {
	@Value("/team/teamForm")
	private String FORM_VIEW;
	@Value("/team/view")
	private String RESULT_VIEW;

    private FrogBanchanFacade frogBanchan;
	private TeamFormValidator validator;

    @Autowired
    public CreateTeamController(FrogBanchanFacade frogBanchan, TeamFormValidator validator) {
        this.frogBanchan = frogBanchan;
        this.validator = validator;
    }

	@ModelAttribute("teamForm")
    public TeamForm createTeamForm() {
        return new TeamForm();
    }
	
    
	@GetMapping
    public String showForm(HttpServletRequest request, Model model) {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		TeamForm teamForm = new TeamForm();
	    teamForm.setCreator(userSession.getUser().getUsername());
	    model.addAttribute("teamForm", teamForm);
        return FORM_VIEW;
    }
	
	@PostMapping
	public String onSubmit(
			@Valid @ModelAttribute("teamForm") TeamForm teamForm, BindingResult bindingResult, Model model) throws Exception {
		if (bindingResult.hasErrors()) {
			return FORM_VIEW;
		}
		
		Team team = teamForm.getTeam();
       
		frogBanchan.insertTeam(team);
		model.addAttribute("team", team);
		
		return RESULT_VIEW;
	}
	
}
