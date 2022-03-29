package com.sopra.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.spring.model.Persona;
import com.sopra.spring.service.PersonaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class PersonaRestController {
	@Autowired
	PersonaService personaService;
	
	@PostMapping(path = "/personas")
	public Persona insert(@RequestBody Persona p) {
		log.debug("Entrando en insert de Persona");
		return p;
	}
	
	@GetMapping("/personas/{id}")
	public Persona getPersonaById(@PathVariable("id") Long personaId) {
		return personaService.getById(personaId);
	}
}
