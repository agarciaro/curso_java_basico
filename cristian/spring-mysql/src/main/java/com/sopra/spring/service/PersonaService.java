package com.sopra.spring.service;

import com.sopra.spring.model.Persona;

public interface PersonaService {

	Persona insert(Persona p);
	Persona getPersonaById(Long personaId);
	Iterable<Persona> getAllPersonas();
	Persona updatePersona(Long personaId, Persona p);
	boolean delete(Long personaId);

}