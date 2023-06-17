package com.frog.frogbanchan.controller.placemenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.frog.frogbanchan.controller.PlaceSession;
import com.frog.frogbanchan.service.FrogBanchanFacade;

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
        String placeId = placeSession.getPlace().getPlaceId();

        return new ModelAndView("/placemenu/list", "placemenuList", frogbanchan.findMenuListByPlaceId(placeId));
    }

}