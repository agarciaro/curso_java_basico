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

import com.sopra.equipo4.model.Alquiler;
import com.sopra.equipo4.model.AlquilerPK;
import com.sopra.equipo4.service.AlquilerService;

@RestController
@RequestMapping("/api")
public class AlquilerRestController {
	
	@Autowired
	AlquilerService alquilerService;
	
	@GetMapping("/alquileres")
	public List<Alquiler> getAlquileres(){
		return alquilerService.findAll();
	}
	
	@GetMapping("/alquileres/{id}")
	public Alquiler getAlquileresById(@PathVariable AlquilerPK id) {
		return alquilerService.findById(id);
	}
	
	@DeleteMapping("/alquileres/{id}")
	public void deleteAlquilerById(AlquilerPK id) {
		alquilerService.deleteAlquilerById(id);
	}
	
	@PutMapping("/alquileres")
	public Alquiler updateAlquiler(@RequestBody Alquiler alquiler) {
		return alquilerService.updateAlquiler(alquiler);
	}
	
	@PostMapping("/alquileres")
	public Alquiler insertAlquiler(@RequestBody Alquiler alquiler) {
		return alquilerService.insertAlquiler(alquiler);
	}
}
