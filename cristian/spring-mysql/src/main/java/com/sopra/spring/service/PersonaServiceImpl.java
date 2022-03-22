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
		
		if (p.getEdad() != null) {
			pDb.setEdad(p.getEdad());
		}
		
		if (p.getNombre() != null) {
			pDb.setNombre(p.getNombre());
		}
		
		return personaRepository.save(pDb);
	}
	
	@Override
	public boolean delete(Long personaId) {
		
		personaRepository.deleteById(personaId);
				
		return personaRepository.findById(personaId).isEmpty() ? true : false;
	}

}
