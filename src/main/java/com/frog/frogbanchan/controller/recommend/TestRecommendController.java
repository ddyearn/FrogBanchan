package com.frog.frogbanchan.controller.recommend;

import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.domain.Team;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

// recommend team, personal view 처리를 위한 임시 컨트롤러 (실제 구현 시 삭제 !!)
@Controller
@SessionAttributes("userSession")
public class TestRecommendController {

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    @RequestMapping("/recommend/personal")
    public ModelAndView test1(
            @ModelAttribute("userSession") UserSession userSession
            ) throws Exception {

        return new ModelAndView("/user/recommendPersonal");
    }

    @RequestMapping("/recommend/team")
    public ModelAndView test2(
            @ModelAttribute("userSession") UserSession userSession,
            @RequestParam("teamId") int teamId
            ) throws Exception {
        Team team = frogBanchan.findTeam(teamId);

        return new ModelAndView("/team/recommendTeam", "team", team);
    }

}
