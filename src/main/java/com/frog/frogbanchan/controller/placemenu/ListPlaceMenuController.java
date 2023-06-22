package com.frog.frogbanchan.controller.placemenu;

import com.frog.frogbanchan.domain.PlaceMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.frog.frogbanchan.controller.PlaceSession;
import com.frog.frogbanchan.service.FrogBanchanFacade;

import java.util.List;

@Controller
@SessionAttributes("placeSession")
public class ListPlaceMenuController {

    private FrogBanchanFacade frogbanchan;

    @Autowired
    public void setFrogbanchan(FrogBanchanFacade frogbanchan) {
        this.frogbanchan = frogbanchan;
    }

    @RequestMapping("/placemenu/list")
    public ModelAndView handleRequest(
            @ModelAttribute("placeSession") PlaceSession placeSession) throws Exception {
        ModelAndView mav = new ModelAndView("/placemenu/placeMenuList");

        String placeId = placeSession.getPlace().getPlaceId();
        List<PlaceMenu> placemenuList = frogbanchan.findMenuListByPlaceId(placeId);
        for (PlaceMenu placeMenu : placemenuList) {
            String menuName = frogbanchan.findMenuByPlaceMenuId(placeMenu.getPlaceMenuId());
            String tagList = "| ";
            List<String> tags = frogbanchan.findMenuTagList(placeMenu.getMenuId());
            for (String tag : tags) {
                tagList += tag + " | ";
            }
            placeMenu.setDescription(menuName + "&AND&" + tagList + "&AND&" + placeMenu.getDescription());
        }

        mav.addObject("placemenuList", placemenuList);

        return mav;
    }

}