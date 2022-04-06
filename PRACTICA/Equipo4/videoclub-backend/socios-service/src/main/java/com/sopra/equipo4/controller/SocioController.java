package com.sopra.equipo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.equipo4.model.Socio;
import com.sopra.equipo4.service.SocioService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class SocioController {
	@Autowired
	SocioService socioService;
	
	@GetMapping("/socios")
	public List<Socio> getSocios(){
		return socioService.findAll();
	}
	
	@GetMapping("/socios/{id}")
	public Socio getSocioById(@PathVariable Integer id) {
		return socioService.findById(id);
	}
	
	@DeleteMapping("/socios/{id}")
	public void deleteSocioById(@PathVariable Integer id) {
		socioService.deleteSocioById(id);
	}

	@PutMapping("/socios")
	public Socio updateSocio(@RequestBody Socio socio) {
		return socioService.updateSocio(socio);
	}

	@PostMapping("/socios")
	public Socio insertSocio(@RequestBody Socio socio) {
		return socioService.insertSocio(socio);
	}
}
