package com.frog.frogbanchan.controller.placemenu;
import com.frog.frogbanchan.controller.PlaceSession;
import com.frog.frogbanchan.domain.Menu;
import com.frog.frogbanchan.domain.PlaceMenu;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Controller
@RequestMapping("/placemenu/create")
public class CreatePlaceMenuController {
    @Value("/placemenu/placemenuForm")
    private String FORM_VIEW;
    @Value("/placemenu/list")
    private String RESULT_VIEW;
    private FrogBanchanFacade frogBanchan;
    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }
    @ModelAttribute("placemenuForm")
    public PlaceMenuForm createPlaceMenuForm() {
        return new PlaceMenuForm();
    }


    @GetMapping
    public String showForm(HttpServletRequest request, HttpSession session, Model model) {
        PlaceSession placeSession = (PlaceSession) request.getSession().getAttribute("placeSession");

        PlaceMenu placeMenu = new PlaceMenu();

        String placeId = placeSession.getPlace().getPlaceId();

        placeMenu.setPlaceId(placeId);

        model.addAttribute("placemenu", placeMenu);
        return FORM_VIEW;
    }

    @PostMapping
    public String onSubmit(
            HttpServletRequest request, HttpSession session,
            @ModelAttribute("placemenuForm") PlaceMenuForm placemenuForm, BindingResult bindingResult, Model model) throws Exception {
        PlaceMenu placeMenu = placemenuForm.getPlaceMenu();

        PlaceSession placeSession = (PlaceSession) request.getSession().getAttribute("placeSession");
        String placeId = placeSession.getPlace().getPlaceId();
        placeMenu.setPlaceId(placeId);

        frogBanchan.insertPlaceMenu(placeMenu);
        model.addAttribute("placemenu", placeMenu);

        return "redirect:/placemenu/list";
    }

    @GetMapping("search")
    @ResponseBody
    public String handleRequest3(@RequestParam("keyword") String keyword) {
        List<Menu> menuList = frogBanchan.findMenuList();
        for (Menu menu : menuList) {
            if (keyword.equals(menu.getName())) {
                return String.valueOf(menu.getMenuId());
            }
        }
        return "false";
    }


}