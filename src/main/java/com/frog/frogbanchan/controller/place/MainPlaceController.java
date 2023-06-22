package com.frog.frogbanchan.controller.place;

import com.frog.frogbanchan.controller.PlaceSession;
import com.frog.frogbanchan.domain.Place;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPlaceController {

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    @RequestMapping("/place/main")
    public ModelAndView handleRequest1(@SessionAttribute("placeSession") PlaceSession placeSession)
            throws Exception {
        ModelAndView mav = new ModelAndView("/place/mainForPlace");

        Place place = placeSession.getPlace();
        mav.addObject("place", place);

        return mav;
    }

    @RequestMapping("/place/myPage")
    public ModelAndView handleMyPage(@SessionAttribute("placeSession") PlaceSession placeSession)
            throws Exception {
        ModelAndView mav = new ModelAndView("/place/myPageForPlace");

        Place place = placeSession.getPlace();
        mav.addObject("place", place);

        return mav;
    }

    @RequestMapping("/place/view")
    public ModelAndView handleView(@RequestParam("placeId") String placeId)
            throws Exception {
        ModelAndView mav = new ModelAndView("/place/placeDetail");

        mav.addObject("place", frogBanchan.findPlaceById(placeId));
        mav.addObject("menuList", frogBanchan.findMenuListByPlaceId(placeId));

        return mav;
    }


}
