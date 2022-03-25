package com.sopra.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CacheException extends RuntimeException{

	private static final long serialVersionUID = -7091777489978208560L;
	
	protected String message = "Error in cache";
	
}
