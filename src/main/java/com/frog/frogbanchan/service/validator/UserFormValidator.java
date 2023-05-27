package com.frog.frogbanchan.service.validator;

import com.frog.frogbanchan.controller.users.UserForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserForm userForm = (UserForm) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.username", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.password", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.nickname", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.email", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.address", "required");

        if (userForm.hasPassword()) {
            if (userForm.getUser().getPassword().length() < 5)
                errors.rejectValue("user.password", "shortPassword");
            else if (!userForm.isSamePasswordConfirmPassword())
                errors.rejectValue("confirmPassword", "notSame");
        }

        String phone = userForm.getUser().getPhone();
        if (phone == null || phone.trim().isEmpty()) {
            errors.rejectValue("user.phone", "required");
        }
        else {
            if (!phone.matches("01[01679]-\\d{3,4}-\\d{4}"))
                errors.rejectValue("user.phone", "invalidFormat");
        }

        String residentNo = userForm.getUser().getResidentNo();
        if (residentNo == null || residentNo.trim().isEmpty()) {
            errors.rejectValue("user.residentNo", "required");
        }
        else {
            if (!residentNo.matches("\\d{7}"))
                errors.rejectValue("user.residentNo", "invalidFormat");
        }

    }

}
