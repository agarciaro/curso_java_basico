package com.sopra.equipo3.videoclub.controller;

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

import com.sopra.equipo3.videoclub.model.Socio;
import com.sopra.equipo3.videoclub.service.SocioService;

@RestController
@RequestMapping("/api/socio")
public class SocioRestController {

	@Autowired
	SocioService socioService;

	@GetMapping()
	public List<Socio> getAllSocios() {
		return socioService.findAll();
	}

	@GetMapping("/{id}")
	public Socio getDirector(@PathVariable Long id) {
		return socioService.findById(id);
	}

	@PostMapping()
	public Socio insertSocio(@RequestBody Socio socio) {
		return socioService.insert(socio);
	}

	@PutMapping()
	public Socio updateDirector(@RequestBody Socio socio) {
		return socioService.update(socio);
	}

	@DeleteMapping("/{id}")
	public void deleteDirector(@PathVariable Long id) {
		socioService.delete(id);
	}
}
