package com.frog.frogbanchan.controller.placemenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.frog.frogbanchan.service.FrogBanchanFacade;

@Controller
public class DeletePlaceMenuController {

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogbanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    @RequestMapping("/placemenu/delete")
    public String handleRequest(
            @RequestParam("placeMenuId") int placeMenuId,
            ModelMap model) throws Exception {
        frogBanchan.deletePlaceMenu(placeMenuId);

        return "redirect:/placemenu/list";
    }

}