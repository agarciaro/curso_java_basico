package com.sopra.spring.service;

import org.springframework.stereotype.Service;

import com.sopra.spring.annotation.LogueaTiempo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PruebasService {
	
	@LogueaTiempo(maxTiempo = 3000)
	public void funcion1() {
		log.info("En funcion1");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
	}
	
	public void funcion2() {
		log.info("En funcion2");
	}
	
	@LogueaTiempo
	public void funcion3() {
		log.info("En funcion3");
	}
	
}
