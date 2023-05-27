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
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/register")
public class UserFormController {

    @Value("/user/userJoinForm")
    private String FORM_VIEW;
    @Value("/user/userRegistResult")
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
    public UserForm formBacking(HttpServletRequest request)
            throws Exception {
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
        if (userSession != null) {
            return new UserForm(userSession.getUser());
        } else {
            return new UserForm();
        }
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
        frogBanchan.insertUser(user);
        model.addAttribute("user", user);

        sessionStatus.setComplete();

        return RESULT_VIEW;
    }

}
