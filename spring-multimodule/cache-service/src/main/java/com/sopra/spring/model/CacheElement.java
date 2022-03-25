package com.sopra.spring.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
//@AllArgsConstructor
public class CacheElement {
	@Setter
	private Object element;
	@Setter
	private boolean valid = true;
	private Long creationTime = System.currentTimeMillis();
	
	public CacheElement(Object e) {
		this.element = e;
	}
}
