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

import com.sopra.videoclub.model.Alquiler;
import com.sopra.videoclub.model.AlquilerKey;
import com.sopra.videoclub.service.AlquilerService;

@RestController
@RequestMapping("/api")
public class AlquilerRestController {

	@Autowired
	AlquilerService alquilerService;;

	@GetMapping("/alquileres")
	public List<Alquiler> getAllAlquileres() {
		return alquilerService.findAllAlquileres();
	}

	@GetMapping("/alquileres/{id}")
	public Alquiler getAlquilerById(@PathVariable Integer id) throws NoSuchElementException {
		return alquilerService.findAlquilerById(id);
	}

	@PutMapping("/alquileres/{id}")
	public Alquiler updateAlquilerById(@PathVariable AlquilerKey id, @RequestBody Alquiler alquiler) {
		alquiler.setId(id);
		return alquilerService.updateAlquiler(alquiler);
	}

	@PostMapping("/alquileres")
	public Alquiler insertAlquiler(@Valid @RequestBody Alquiler alquiler) {
		return alquilerService.insertAlquiler(alquiler);
	}

	@DeleteMapping("/alquileres/{id}")
	public void deleteAlquilerById(@PathVariable Integer id) {
		alquilerService.deleteAlquiler(id);
	}

}