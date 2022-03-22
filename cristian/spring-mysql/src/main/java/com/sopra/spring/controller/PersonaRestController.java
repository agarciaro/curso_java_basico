package com.sopra.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.spring.model.Persona;
import com.sopra.spring.service.PersonaService;


@RestController
@RequestMapping(path = "/api")
public class PersonaRestController {

	@Autowired
	PersonaService personaService;

	@PostMapping(path = "/personas")
	public Persona insert(@RequestBody Persona p) {
		return personaService.insert(p);
	}

	@GetMapping(path = "/personas/{id}")
	public Persona getPersonaById(@PathVariable("id") Long personaId) {
		return personaService.getPersonaById(personaId);
	}

	@GetMapping(path = "/personas")
	public Iterable<Persona> getAllPersonas() {
		return personaService.getAllPersonas();
	}

	@PostMapping(path = "/personas/{id}")
	public Persona update(@PathVariable("id") Long personaId, @RequestBody Persona p) {
		return personaService.updatePersona(personaId, p);
	}

	@DeleteMapping(path = "/personas/{id}")
	public String delete(@PathVariable("id") Long personaId) {
		return personaService.delete(personaId) ? "Se ha eliminado con éxito." : "No se ha podido eliminar.";
	}

}
