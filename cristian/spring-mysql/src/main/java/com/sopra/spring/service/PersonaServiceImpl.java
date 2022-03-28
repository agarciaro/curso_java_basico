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
	public Persona getPersonaById(Long personaId) {
		return personaRepository.findById(personaId).get();
	}

	@Override
	public Iterable<Persona> getAllPersonas() {
		return personaRepository.findAll();
	};
	
	@Override
	public Persona updatePersona(Long personaId, Persona p) {
		
		Persona pDb = personaRepository.findById(personaId).get();
		
		pDb.setNombre(p.getNombre() != null ? p.getNombre() : pDb.getNombre());
		pDb.setEdad(p.getEdad() != null ? p.getEdad() : pDb.getEdad());
		
		return personaRepository.save(pDb);
	}
	
	@Override
	public boolean delete(Long personaId) {
		
		personaRepository.deleteById(personaId);
				
		return personaRepository.findById(personaId).isEmpty() ? true : false;
	}

}
