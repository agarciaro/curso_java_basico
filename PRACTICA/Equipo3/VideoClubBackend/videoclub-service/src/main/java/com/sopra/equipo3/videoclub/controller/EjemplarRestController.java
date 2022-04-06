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

import com.sopra.equipo3.videoclub.model.Ejemplar;
import com.sopra.equipo3.videoclub.service.EjemplarService;

@RestController
@RequestMapping("/api/ejemplar")
public class EjemplarRestController {
	@Autowired
	EjemplarService ejemplarService;

	@GetMapping()
	public List<Ejemplar> getAllDirectors() {
		return ejemplarService.findAll();
	}

	@GetMapping("/{id}")
	public Ejemplar getEjemplar(@PathVariable Long id) {
		return ejemplarService.findById(id);
	}

	@PostMapping()
	public Ejemplar insertEjemplar(@RequestBody Ejemplar ejemplar) {
		return ejemplarService.insert(ejemplar);
	}

	@PutMapping()
	public Ejemplar updateEjempla(@RequestBody Ejemplar ejemplar) {
		return ejemplarService.update(ejemplar);
	}

	@DeleteMapping("/{id}")
	public void deleteEjempla(@PathVariable Long id) {
		ejemplarService.delete(id);
		
	}

}
