package com.sopra.spring.controller;

import javax.websocket.server.PathParam;

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
@RequestMapping(path = "/api")
@Slf4j
public class PersonaRestController {
	@Autowired
	PersonaService personaService;

	@PostMapping(path = "/personas")  //Inserta la persona que le creas desde Postman
	public Persona insert(@RequestBody Persona p) {
		log.debug("Entrando en insert de Persona");
		//p.setId(1000);
		return personaService.insert(p);
	}

	@GetMapping("/personas/{id}") // Devuelve el objeto que tiene ese id
	public Persona getPersonaById(@PathVariable("id") Long personaId) { // En el PathVariable le pasas el nombre de la
																		// base de datos

		return personaService.getById(personaId);
	}
}
