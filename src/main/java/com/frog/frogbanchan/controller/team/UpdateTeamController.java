package com.frog.frogbanchan.controller.team;
import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.domain.Team;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import com.frog.frogbanchan.service.FrogBanchanImpl;
import com.frog.frogbanchan.service.validator.TeamFormValidator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Value;

@Controller
@RequestMapping("/team/update.do")
public class UpdateTeamController {
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
    public String showForm(@RequestParam(value="teamId") int teamId, Model model, @ModelAttribute("teamForm") TeamForm teamForm, HttpServletRequest request) {
		Team team = frogBanchan.findTeam(teamId);
		if (team == null) {
			return "redirect:/team/list";
		}
		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		team.setTeamId(team.getTeamId());
		String creator = userSession.getUser().getUsername();
		team.setCreator(creator);

		model.addAttribute("team", team);
        return "/team/teamUpdateForm";
    }

	@PostMapping
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("teamForm") TeamForm teamForm, BindingResult bindingResult, Model model) throws Exception {
		Team team = teamForm.getTeam();

		validator.validate(teamForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/team/teamUpdateForm";
		}

		frogBanchan.updateTeam(team);
		model.addAttribute("team", team);
		
		return "/team/view";
	}
	
}