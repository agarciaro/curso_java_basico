package com.sopra.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sopra.spring.exception.CacheEvictedException;
import com.sopra.spring.exception.CacheException;
import com.sopra.spring.exception.CacheNotFoundException;
import com.sopra.spring.model.CacheError;
import com.sopra.spring.service.CacheManager;

@ControllerAdvice
public class CacheRestErrorHandler {
	
	@Autowired
	CacheManager cacheManager;
	
	@ExceptionHandler({CacheNotFoundException.class, CacheEvictedException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ResponseBody
	public CacheError handleCacheNotFound(CacheException e) {
		CacheError error = new CacheError();
		error.setMode(cacheManager.getMode());
		error.setMessage(e.getMessage());
		
		return error;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public CacheError handleCacheError(Exception e) {
		CacheError error = new CacheError();
		error.setMode(cacheManager.getMode());
		error.setMessage("Ha ocurrido un error al ejecutar la operación en cache");
		
		return error;
	}
	
}
