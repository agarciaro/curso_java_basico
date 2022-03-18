package com.sopra.prueba;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
//@Slf4j
public class Constructores {

	private String palabra = "hola";
	{
		palabra = "Pepe";
	}

	public Constructores() {
		this(1);
		palabra = "juan";
	}
	
	@Override
	public String toString() {
		return null;
	}
	
//	@Override
	public String aString() {
		return null;
	}

	public Constructores(Integer a) {
//		log.info(2);
	}
	
	public Constructores(Integer a, Integer b) {
		System.out.println(2);
	}

}
