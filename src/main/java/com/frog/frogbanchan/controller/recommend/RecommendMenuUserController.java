package com.frog.frogbanchan.controller.recommend;

import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@SessionAttributes("userSession")
public class RecommendMenuUserController {

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

        int placeMenuId = frogBanchan.getHistoryMenu(userSession.getUser().getUsername());
        String historyMenu = frogBanchan.findMenuByPlaceMenuId(placeMenuId);
        hateList.add(historyMenu);

        Map<String, List<String>> tagList = new HashMap<>();
        tagList.put("like", likeList);
        tagList.put("dislike", hateList);
        System.out.println(frogBanchan.findMenuListByTagList(tagList));
        return mav;
    }
}
