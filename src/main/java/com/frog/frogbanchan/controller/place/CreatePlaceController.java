package com.frog.frogbanchan.controller.place;

import com.frog.frogbanchan.controller.PlaceSession;
import com.frog.frogbanchan.domain.Place;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import com.frog.frogbanchan.service.validator.PlaceFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/join/place")
public class CreatePlaceController {

    @Value("/place/placeJoinForm")
    private String FORM_VIEW;
    @Value("/place/placeCreateResult")
    private String RESULT_VIEW;

    private FrogBanchanFacade frogBanchan;
    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }


    @ModelAttribute("placeForm")
    public PlaceForm formBacking(HttpServletRequest request)
            throws Exception {
        PlaceSession placeSession = (PlaceSession) WebUtils.getSessionAttribute(request, "placeSession");
        if (placeSession != null) {
            return new PlaceForm(placeSession.getPlace());
        } else {
            return new PlaceForm();
        }
    }

    @Autowired
    private PlaceFormValidator validator;
    public void setValidator(PlaceFormValidator validator) {
        this.validator = validator;
    }

    @GetMapping
    public String showForm() {
        return FORM_VIEW;
    }

    @PostMapping
    public String onSubmit(@ModelAttribute("placeForm") PlaceForm placeForm,
                          BindingResult bindingResult, Model model) {
        System.out.println("command 객체: " + placeForm);

        validator.validate(placeForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return FORM_VIEW;
        }

        Place place = placeForm.getPlace();
        frogBanchan.insertPlace(place);
        model.addAttribute("place", place);

        return RESULT_VIEW;
    }

    @GetMapping("placeId/{placeId}")
    @ResponseBody
    public String isExistUsername(@PathVariable("placeId") String placeId) {
        String result;
        List<String> placeList = frogBanchan.findAllPlaceIdList();
        if (!placeList.contains(placeId)) {
            result = "true";
        } else {
            result = "false";
        }
        return result;
    }


}
