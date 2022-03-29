package com.sopra.biblioteca;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sopra.biblioteca.reporsitory.LlibreRepository;
import com.sopra.biblioteca.reporsitory.SociRepository;
import com.sopra.biblioteca.service.DummiesService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SocisApplication {

	@Autowired
	DummiesService dummiesService;
//	SociRepository sociRepository;

	public static void main(String[] args) {
		SpringApplication.run(SocisApplication.class, args);

	}

//	@PostConstruct
	public void metodoPrueba() {
//		dummiesService.impTema(1);
//		dummiesService.impTema(2);
//		dummiesService.impTema(3);
//		dummiesService.impTema(4);
		
		dummiesService.imprimirExemplars();

//		log.info("{}", llibreRepository.findById(1).get().getTema());
//		log.info("{}", socisRepository.findAll());

	}

}
