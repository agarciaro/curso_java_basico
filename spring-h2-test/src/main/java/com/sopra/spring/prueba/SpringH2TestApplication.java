package com.sopra.spring.prueba;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sopra.spring.prueba.repository.PersonaRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringH2TestApplication {
	
	@Autowired
	PersonaRepository personaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringH2TestApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		log.info("PERSONAS: {}", personaRepository.findAll());
		log.info("NOMBRE: {}", personaRepository.findByNombre("Pepe"));
	}

}
