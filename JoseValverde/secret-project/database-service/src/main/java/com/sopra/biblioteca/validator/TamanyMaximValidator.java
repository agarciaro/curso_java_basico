package com.sopra.biblioteca.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sopra.biblioteca.annotation.TamanyMaxim;

public class TamanyMaximValidator implements ConstraintValidator<TamanyMaxim, String> {

	
	TamanyMaxim annotation;
	
	@Override
	public void initialize(TamanyMaxim constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
		annotation = constraintAnnotation;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.length() > annotation.tamany()) {
			return false;
		}
		return true;
	}
	

}
