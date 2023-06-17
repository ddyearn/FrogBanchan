package com.frog.frogbanchan.controller.placemenu;
import com.frog.frogbanchan.domain.PlaceMenu;

import com.frog.frogbanchan.service.FrogBanchanFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/placemenu/update")
public class UpdatePlaceMenuController {
    private FrogBanchanFacade frogBanchan;
    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }
//    @ModelAttribute("placemenuForm")
//    public PlaceMenuForm createPlaceMenuForm() {
//        return new PlaceMenuForm();
//    }


    @ModelAttribute("placemenuForm")
    public PlaceMenuForm formBacking(@RequestParam(value="placeMenuId") int placeMenuId){
        PlaceMenuForm placeMenuForm = new PlaceMenuForm(frogBanchan.findPlaceMenu(placeMenuId));
        placeMenuForm.getPlaceMenu().setPlaceMenuId(placeMenuId);

        return placeMenuForm;
    }
    @GetMapping
    public String showForm(@RequestParam(value="placeMenuId") int placeMenuId, Model model) {
        model.addAttribute("placeMenuId", placeMenuId);
        return "/placemenu/placemenuUpdateForm";
    }

    @PostMapping
    public String onSubmit(
            HttpServletRequest request, HttpSession session,
            @ModelAttribute("placemenuForm") PlaceMenuForm placemenuForm, BindingResult bindingResult, Model model) throws Exception {
        PlaceMenu placeMenu = placemenuForm.getPlaceMenu();

        frogBanchan.updatePlaceMenu(placeMenu);
        model.addAttribute("placemenu", placeMenu);

        return "redirect:/placemenu/list";
    }

}