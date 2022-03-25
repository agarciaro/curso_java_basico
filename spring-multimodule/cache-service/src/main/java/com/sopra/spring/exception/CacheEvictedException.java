package com.sopra.spring.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CacheEvictedException extends CacheException {

	public CacheEvictedException(String message) {
		super(message);
	}
	
}
