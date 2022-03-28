package com.sopra.biblioteca;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sopra.biblioteca.reporsitory.SocisRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SocisApplication {

	@Autowired
	SocisRepository socisRepository;

	public static void main(String[] args) {
		SpringApplication.run(SocisApplication.class, args);

	}

	@PostConstruct
	public void metodoPrueba() {
		log.info("{}", socisRepository.findAll());
	}
	
}
