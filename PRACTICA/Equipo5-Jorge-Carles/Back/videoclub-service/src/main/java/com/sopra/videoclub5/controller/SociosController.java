package com.sopra.videoclub5.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.videoclub5.modelEntity.Socio;
import com.sopra.videoclub5.service.SociosService;

@RestController
@RequestMapping("/api")
public class SociosController {

	@Autowired
	SociosService sociosService;

	@GetMapping("/socios")
	public List<Socio> getAllSocios() {
		return sociosService.findAll();
	}

	@GetMapping("/socios/{numSocio}")
	public Socio getSocioByNumSocio(@PathVariable Integer numSocio) throws NoSuchElementException {
		return sociosService.findByNumSocio(numSocio);

	}

	@DeleteMapping("/socios/{numSocio}")
	public void deleteSocio(@PathVariable Integer numSocio) throws NoSuchElementException {
		sociosService.delete(numSocio);
	}

	@PostMapping("/socios")
	public Socio insertSocio(@Validated @RequestBody Socio socio) {
		return sociosService.insert(socio);
	}

	@PutMapping("/socios/{numSocio}")
	public Socio updateSocioByNumSocio(@PathVariable Integer numSocio, @RequestBody Socio socio) {
		return sociosService.update(socio);
	}

}
