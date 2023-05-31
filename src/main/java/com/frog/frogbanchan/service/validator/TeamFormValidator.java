package com.frog.frogbanchan.service.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.frog.frogbanchan.controller.team.TeamForm;

@Component
public class TeamFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TeamForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "team.name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "team.address", "required");
	}
}