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

@Controller
public class RecommendMenuTeamController {

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    // (팀)추천하러 가기 버튼 -> 팀원 선택 페이지
    // teamSession에 team 정보가 저장된 상황
    // recommend -> 맨 아래 컨트롤러!!!
    @RequestMapping("/recommend/team")
    public ModelAndView selectMember(@SessionAttribute("teamSession") TeamSession teamSession
    ) throws Exception {
        ModelAndView mav = new ModelAndView("/team/recommendTeam");

        // team에 속한 모든 멤버 목록을 불러옴
        // 선택된 멤버 목록이 session에 저장되어 있으면 그것을 팀원 선택 페이지에 반영
        Team team = teamSession.getTeam();
        List<Users> memberList = frogBanchan.findTeamMembers(team.getTeamId());
        List<Users> selectedMembers = new ArrayList<>();
        if (teamSession.getSelectedMembers() != null) {
            selectedMembers.addAll(teamSession.getSelectedMembers());
            for (Users member: selectedMembers) {
                memberList.remove(member);
            }
        }
        // 선택된 태그 목록도 session에 저장되어 있으면 불러옴
        List<String> selectedTags = new ArrayList<>();
        if (teamSession.getSelectedTags() != null) {
            selectedTags.addAll(teamSession.getSelectedTags());
        }

        mav.addObject("team", team);
        mav.addObject("memberList", memberList);
        mav.addObject("selectedMembers", selectedMembers);
        mav.addObject("selectedTags", selectedTags);

        return mav;
    }

    // 팀원 선택 처리용이라 신경 안 써도 되는 거시기
    // 팀원이 가진 hate tag 목록을 가져옴
    @GetMapping("/recommend/team/list-tags/{user}")
    @ResponseBody
    public List<String> getHateList(
            @PathVariable("user") String username
    ) throws Exception {
        List<String> hateTags = frogBanchan.findTagsByUsername(username);
        System.out.println(hateTags);

        return hateTags;
    }

    // 추천go 버튼 -> 선택 결과 페이지
    // request url: user/recommendTeam.jsp의 form action 값
    @RequestMapping("/recommend/team/test1")
    public ModelAndView recommendTeam(
            @SessionAttribute("teamSession") TeamSession teamSession,
            @RequestParam("hateTags") String hateTags,
            @RequestParam("selectedMember") String selectedMember
    ) throws Exception {
        
        // test 결과 페이지, 구현 시 recommend 결과 페이지로
        ModelAndView mav = new ModelAndView("/team/recommendTest2");

        // 선택된 싫어요, 좋아요 태그 목록을 List<String> 형태로 저장
        // 세션 처리 ok, 뒤로가기 ok
        // ModelAndView에 넣은 이유: 값 확인용
        List<String> hateList = new ArrayList<>(Arrays.asList(hateTags.split(",")));
        teamSession.setSelectedTags(hateList);
        mav.addObject("hateList", hateList);

        // 선택된 팀원 목록을 List<Users> 형태로 세션에 저장
        // 세션 처리 ok, 뒤로가기 ok
        // 히스토리 처리할 때는 session에서 팀원 목록 꺼내도 조으다
        List<String> members = new ArrayList<>(Arrays.asList(selectedMember.split(",")));
        List<Users> memberList = new ArrayList<>();
        for (String member : members) {
            memberList.add(frogBanchan.findUserByUsername(member));
        }
        teamSession.setSelectedMembers(memberList);
        mav.addObject("memberList", memberList);

        // 여기에서 hateList 사용하믄 될가나






        return mav;
    }

}
