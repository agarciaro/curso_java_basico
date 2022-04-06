package com.sopra.videoclub.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.videoclub.model.Socio;
import com.sopra.videoclub.service.SocioService;

@RestController
@RequestMapping("/api")
public class SocioRestController {

	@Autowired
	SocioService socioService;;

	@GetMapping("/socios")
	public List<Socio> getAllSocios() {
		return socioService.findAllSocios();
	}

	@GetMapping("/socios/{id}")
	public Socio getSocioById(@PathVariable Integer id) throws NoSuchElementException {
		return socioService.findSocioById(id);
	}

	@PutMapping("/socios/{id}")
	public Socio updateSocioById(@PathVariable Integer id, @RequestBody Socio socio) {
		socio.setId(id);
		return socioService.updateSocio(socio);
	}

	@PostMapping("/socios")
	public Socio insertSocio(@Valid @RequestBody Socio socio) {
		return socioService.insertSocio(socio);
	}

	@DeleteMapping("/socios/{id}")
	public void deleteSocioById(@PathVariable Integer id) {
		socioService.deleteSocio(id);
	}

}