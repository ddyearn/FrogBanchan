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
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/place/modify")
public class UpdatePlaceController {

    @Value("/place/placeModify")
    private String FORM_VIEW;
    @Value("redirect:/place/myPage")
    private String RESULT_VIEW;

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    @Autowired
    private PlaceFormValidator validator;
    public void setValidator(PlaceFormValidator validator) {
        this.validator = validator;
    }

    @ModelAttribute("placeForm")
    public PlaceForm formBacking(@SessionAttribute("placeSession") PlaceSession placeSession)
            throws Exception {
        PlaceForm placeForm = new PlaceForm(placeSession.getPlace());
        placeForm.setConfirmPassword(placeSession.getPlace().getPassword());
        return placeForm;
    }

    @GetMapping
    public String showForm() {
        return FORM_VIEW;
    }

    @PostMapping
    public String onSubmit(
            /*@Valid*/ @ModelAttribute("placeForm") PlaceForm placeForm,
                       BindingResult bindingResult, Model model,
                       SessionStatus sessionStatus) {
        System.out.println("command 객체: " + placeForm);

        validator.validate(placeForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return FORM_VIEW;
        }

        Place place = placeForm.getPlace();
        frogBanchan.updatePlace(place);
        model.addAttribute("place", place);

        return RESULT_VIEW;
    }
}
