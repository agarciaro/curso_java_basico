package com.sopra.biblioteca.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.sopra.biblioteca.validator.TamanyMaximValidator;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = TamanyMaximValidator.class)
public @interface TamanyMaxim {
	
	int tamany() default 100;
	
	String message() default "Tamany maxim excedit";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
