package com.sopra.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.biblioteca.model.Exemplar;
import com.sopra.biblioteca.model.Llibre;
import com.sopra.biblioteca.reporsitory.ExemplarRepository;
import com.sopra.biblioteca.reporsitory.LlibreRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class DummiesService {

	@Autowired
	LlibreRepository llibreRepository;
	@Autowired
	ExemplarRepository exemplarRepository;

	@Async
	public void impTema(Integer codiLlibre) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("{}", llibreRepository.findById(1).get().getTema());

	}

	@Async
	public void imprimirExemplars() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Llibre llibre = llibreRepository.findById(1000).get();
		
//		for (Exemplar exemplar : llibre.getExemplars()) {
//			
//		}
		
//		List<Exemplar> allExemplars = (List<Exemplar>) exemplarRepository.findAll();
//		log.info("findAll ejecutado");
//		Llibre llibre = allExemplars.get(0).getLlibre();
//		log.info("{}", llibre);

	}
	
	@Scheduled(fixedDelay = 2000)
	public void holaMundo() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Hola mundo! SCHEDULED");
	}

}
