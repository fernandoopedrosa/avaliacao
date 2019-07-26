package br.com.vetta.avaliacao.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.vetta.avaliacao.modelo.Tool;

public class ToolValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Tool.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "link", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "description", "field.required");		
	}
	
}
