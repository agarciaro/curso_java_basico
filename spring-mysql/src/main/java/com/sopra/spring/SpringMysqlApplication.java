package com.sopra.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sopra.spring.model.Persona;
import com.sopra.spring.repository.PersonaRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringMysqlApplication {
	
	@Autowired
	PersonaRepository personaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		Persona p = personaRepository.save(new Persona(null, "Persona1", 30));
		log.info("Persona: {}", p);
	}

}
