package com.frog.frogbanchan.service.validator;

import com.frog.frogbanchan.controller.place.PlaceForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PlaceFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PlaceForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PlaceForm placeForm = (PlaceForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "place.placeId", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "place.password", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "place.name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "place.address", "required");

        if (placeForm.hasPassword()) {
            if (placeForm.getPlace().getPassword().length() < 5)
                errors.rejectValue("place.password", "shortPassword");
            else if (!placeForm.isSamePasswordConfirmPassword())
                errors.rejectValue("confirmPassword", "notSame");
        }

    }
}
