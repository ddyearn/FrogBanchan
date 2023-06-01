package com.frog.frogbanchan.service.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.frog.frogbanchan.controller.party.PartyForm;

@Component
public class PartyFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PartyForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "party.meetDate", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "party.placeId", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "party.content", "required");
	}
}