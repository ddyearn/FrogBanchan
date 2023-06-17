package com.frog.frogbanchan.controller.recommend;

import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class RecommendMenuUserController {

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    // (개인)메뉴 추천 버튼 -> 태그 선택 페이지
    @RequestMapping("/recommend/personal")
    public ModelAndView selectTag(
            @SessionAttribute("userSession") UserSession userSession
    ) throws Exception {
        ModelAndView mav = new ModelAndView("/user/recommendPersonal");

        // user의 원래 설정되어있던 hate tag 목록을 넘김
        String user = userSession.getUser().getUsername();
        List<String> hateList = frogBanchan.findTagsByUsername(user);
        mav.addObject("hateList", hateList);

        return mav;
    }

    // 추천go 버튼 -> 선택 결과 페이지
    // request url: user/recommendPersonal.jsp의 form action 값
    @RequestMapping("/recommend/personal/test1")
    public ModelAndView recommendPersonal(
            @SessionAttribute("userSession") UserSession userSession,
            @RequestParam("likeTags") String likeTags,
            @RequestParam("hateTags") String hateTags
    ) throws Exception {

        // test 결과 페이지(recommend 결과 페이지)
        ModelAndView mav = new ModelAndView("/user/recommendTest1");

        // 선택된 싫어요, 좋아요 태그 목록을 List<String> 형태로 저장
        // 아직 얘네는 세션 처리를 안 해서 뒤로가기 누르면 거시기해지는 문제가..
        // ModelAndView에 넣은 이유: 값 확인용
        List<String> hateList = new ArrayList<>(Arrays.asList(hateTags.split(",")));
        mav.addObject("hateList", hateList);
        List<String> likeList = new ArrayList<>(Arrays.asList(likeTags.split(",")));
        mav.addObject("likeList", likeList);
        
        // 여기에서 hateList, likeList 가지고 추천해주시믄 될가나
        // 아니믄 service 클래스에서 처리하게 호출해도 조코
        
        
        

        return mav;
    }
}
