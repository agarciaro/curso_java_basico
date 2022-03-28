package com.sopra.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	
	@PostMapping(path = "/personas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Persona insert(@RequestBody Persona p) {
		log.debug("Entrando en insert de Persona");
		return personaService.insert(p);
	}
}
