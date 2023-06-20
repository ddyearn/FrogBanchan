package com.frog.frogbanchan.controller.users;

import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.domain.Users;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import com.frog.frogbanchan.service.validator.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/user/modify")
public class UpdateUserController {
    @Value("/user/userModify")
    private String FORM_VIEW;
    @Value("redirect:/user/myPage")
    private String RESULT_VIEW;

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    @Autowired
    private UserFormValidator validator;
    public void setValidator(UserFormValidator validator) {
        this.validator = validator;
    }

    @ModelAttribute("userForm")
    public UserForm formBacking(@SessionAttribute("userSession") UserSession userSession)
            throws Exception {
        UserForm userForm = new UserForm(userSession.getUser());
        userForm.setConfirmPassword(userSession.getUser().getPassword());
        userForm.setResidentNo1(userSession.getUser().getResidentNo().substring(0, 6));
        userForm.setResidentNo2(userSession.getUser().getResidentNo().substring(6, 7));
        return userForm;
    }

    @GetMapping
    public String showForm() {
        return FORM_VIEW;
    }

    @PostMapping
    public String onSubmit(
            /*@Valid*/ @ModelAttribute("userForm") UserForm userForm,
                       BindingResult bindingResult, Model model,
                       SessionStatus sessionStatus) {
        System.out.println("command 객체: " + userForm);

        validator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return FORM_VIEW;
        }

        Users user = userForm.getUser();
        user.setResidentNo(userForm.getResidentNo1() + userForm.getResidentNo2());
        frogBanchan.updateUser(user);
        model.addAttribute("user", user);

        return RESULT_VIEW;
    }


}
