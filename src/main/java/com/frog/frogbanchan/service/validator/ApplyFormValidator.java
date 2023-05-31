package com.frog.frogbanchan.service.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.frog.frogbanchan.controller.party.ApplyForm;


@Component
public class ApplyFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ApplyForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apply.name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apply.address", "required");
	}
}