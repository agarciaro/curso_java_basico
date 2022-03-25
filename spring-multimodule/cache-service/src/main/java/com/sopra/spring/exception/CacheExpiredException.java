package com.sopra.spring.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CacheExpiredException extends CacheException {
	
	public CacheExpiredException(String message) {
		super(message);
	}
	
}
