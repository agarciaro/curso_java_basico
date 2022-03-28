package com.sopra.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.spring.model.Persona;
import com.sopra.spring.repository.PersonaRepository;

@Service
public interface PersonaServiceImpl extends PersonaService {

	@Autowired
	PersonaRepository personaRepository;
	
}
