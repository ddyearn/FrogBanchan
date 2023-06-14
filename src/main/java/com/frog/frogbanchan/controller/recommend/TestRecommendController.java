package com.frog.frogbanchan.controller.recommend;

import com.frog.frogbanchan.controller.TeamSession;
import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.domain.Team;
import com.frog.frogbanchan.domain.Users;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        ModelAndView mav = new ModelAndView("/user/recommendPersonal");
        String user = userSession.getUser().getUsername();
        List<String> hateList = frogBanchan.findTagsByUsername(user);
        mav.addObject("hateList", hateList);
        return mav;
    }

    @RequestMapping("/recommend/personal/test1")
    public ModelAndView test4(
            @ModelAttribute("userSession") UserSession userSession,
            @RequestParam("likeTags") String likeTags,
            @RequestParam("hateTags") String hateTags
    ) throws Exception {
        ModelAndView mav = new ModelAndView("/user/recommendTest1");

        List<String> hateList = new ArrayList<>(Arrays.asList(hateTags.split(",")));
        mav.addObject("hateList", hateList);
        List<String> likeList = new ArrayList<>(Arrays.asList(likeTags.split(",")));
        mav.addObject("likeList", likeList);

        return mav;
    }

    @RequestMapping("/recommend/team")
    public ModelAndView test2(
            @ModelAttribute("userSession") UserSession userSession,
            @SessionAttribute("teamSession") TeamSession teamSession
    ) throws Exception {
        ModelAndView mav = new ModelAndView("/team/recommendTeam");

        Team team = teamSession.getTeam();
        List<Users> memberList = frogBanchan.findTeamMembers(team.getTeamId());
//        teamSession.setSelectedMember(memberList);

        mav.addObject("team", team);
        mav.addObject("memberList", memberList);

        return mav;
    }

    @GetMapping("/recommend/team/list-tags/{user}")
    @ResponseBody
    public List<String> getHateList(
            @PathVariable("user") String username
    ) throws Exception {

        List<String> hateTags = frogBanchan.findTagsByUsername(username);
        System.out.println(hateTags);

        return hateTags;
    }

    @RequestMapping("/recommend/team/test1")
    public ModelAndView test5(
            @ModelAttribute("userSession") UserSession userSession,
            @SessionAttribute("teamSession") TeamSession teamSession,
            @RequestParam("hateTags") String hateTags
    ) throws Exception {
        ModelAndView mav = new ModelAndView("/user/recommendTest2");

        List<String> hateList = new ArrayList<>(Arrays.asList(hateTags.split(",")));
        mav.addObject("hateList", hateList);

        return mav;
    }

}
