package com.frog.frogbanchan.controller.recommend;

import com.frog.frogbanchan.domain.Place;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class RecommendPlaceController {

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    @RequestMapping("/recommend/map")
    public ModelAndView selectMenu(
            @RequestParam("menuName") String name,
            @RequestParam("menuId") int menuId,
            ModelMap model
    ) throws Exception {
        ModelAndView mav = new ModelAndView("/recommend/map");
        mav.addObject("menuName", name);

        List<Place> placeList = frogBanchan.findPlaceListByMenu(menuId);

        mav.addObject(placeList);

        return mav;
    }

    //수정해야함
    //추천 결과 매핑
    @RequestMapping("/recommend/result")
    public ModelAndView recommendResult(
            @RequestParam(value="placeId") String placeId,
            ModelMap model
    ) throws Exception {
        ModelAndView mav = new ModelAndView("/recommend/recommendResult");

        String placeName = frogBanchan.findPlaceById(placeId).getName();
        mav.addObject("placeName", placeName);
        return mav;
    }
    
}
