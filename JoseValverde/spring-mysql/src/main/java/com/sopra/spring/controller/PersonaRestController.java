package com.sopra.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.spring.model.Persona;
import com.sopra.spring.service.PersonaSevice;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/api")
@Slf4j
public class PersonaRestController {
	
	@Autowired
	PersonaSevice personaService;
	
	@PostMapping(path ="/personas")
	public Persona insert(@RequestBody Persona p) {
		log.debug("Entrando en insert de Persona");
		return personaService.insert(p);
	}
	
}
