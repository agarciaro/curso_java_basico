package com.sopra.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.spring.model.Persona;
import com.sopra.spring.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Override
	public Persona insert(Persona p) {
		return personaRepository.save(p);
	}

	@Override
	public Persona getPersona(Long id) {
		return personaRepository.findById(id).get();
	}

}
