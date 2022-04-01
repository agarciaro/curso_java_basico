package com.sopra.biblioteca.aop;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sopra.biblioteca.model.ApiError;

@ControllerAdvice
public class SocisControllerAdvice {
	
	@ExceptionHandler({NoSuchElementException.class})
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ApiError notFoundHandler(NoSuchElementException e) {
		return new ApiError(e.getMessage());
	}
}
