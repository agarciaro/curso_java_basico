package com.sopra.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sopra.biblioteca.reporsitory.LlibreRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DummiesService {
	
	@Autowired
	LlibreRepository llibreRepository;
	
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
}
