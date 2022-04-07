package com.sopra.equipoa.videoclub.aop;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sopra.equipoa.videoclub.model.ApiError;

@ControllerAdvice
public class VideoclubControllerAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError validationExceptionHandler(MethodArgumentNotValidException e) {
		return new ApiError(e.getMessage(), e.getAllErrors());
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ResponseBody
	public ApiError badCredentialsExceptionHandler(BadCredentialsException e) {
		return new ApiError(e.getMessage(), null);
	}
	
}
