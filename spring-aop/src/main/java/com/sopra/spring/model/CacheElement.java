package com.sopra.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CacheElement {
	private Object element;
	private boolean valid = false;
}
