package com.frog.frogbanchan.controller.team;
import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.domain.Team;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import com.frog.frogbanchan.service.ParticipationService;
import com.frog.frogbanchan.service.validator.TeamFormValidator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;
@Controller
@RequestMapping("/team/create")
public class CreateTeamController {
	@Value("/team/teamForm")
	private String FORM_VIEW;

    private FrogBanchanFacade frogBanchan;
    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }
    
	private ParticipationService participationService;
	@Autowired
	public void setParticipationService(ParticipationService participationService) {
        this.participationService = participationService;
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
    public String showForm(HttpServletRequest request, HttpSession session, Model model) {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		
		//팀아이디 시퀀스 값 출력
		Team team = new Team();
		int teamId = frogBanchan.getNextId();
		team.setTeamId(teamId);
		
		//팀 생성을 진행하는 user(현재 UserSession)가 팀장으로 자동 지정되도록
		String creator = userSession.getUser().getUsername();
		team.setCreator(creator);

		model.addAttribute("team", team);
        return FORM_VIEW;
    }

	@PostMapping
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("teamForm") TeamForm teamForm, BindingResult bindingResult, Model model) throws Exception {
		Team team = teamForm.getTeam();

		validator.validate(team, bindingResult);
		if (bindingResult.hasErrors()) {
			return FORM_VIEW;
		}
		
		
		participationService.createTeam(team, team.getCreator());
		model.addAttribute("team", team);
		
		return "redirect:/team/main/" + team.getTeamId();
	}
	
}