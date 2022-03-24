package com.sopra.spring.annotation;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PruebasService {
	
	@LogueaTiempo(maxTiempo = 5000)
	public void funcion1() {
		log.info("En funcion1");
	}
	
	public void funcion2() {
		log.info("En funcion2");
	}
	
	@LogueaTiempo
	public void funcion3() {
		log.info("En funcion3");
	}
	
}
