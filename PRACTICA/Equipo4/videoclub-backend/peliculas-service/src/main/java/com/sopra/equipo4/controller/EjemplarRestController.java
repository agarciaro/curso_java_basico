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

import com.sopra.equipo4.model.Ejemplar;
import com.sopra.equipo4.service.EjemplarService;

@RestController
@RequestMapping("/api")
public class EjemplarRestController {
	
	@Autowired
	EjemplarService ejemplarService;
	
	@GetMapping("/ejemplares")
	public List<Ejemplar> getEjemplares() {
		return ejemplarService.findAll();
	}

	@GetMapping("/ejemplares/{id}")
	public Ejemplar findEjemplarById(@PathVariable Integer id) {
		return ejemplarService.findById(id);
	}

	@DeleteMapping("/ejemplares/{id}")
	public void deleteEjemplarById(@PathVariable Integer id) {
		ejemplarService.deleteEjemplarById(id);
	}

	@PutMapping("/ejemplares")
	public Ejemplar updateEjemplar(@RequestBody Ejemplar ejemplar) {
		return ejemplarService.updateEjemplar(ejemplar);
	}

	@PostMapping("/ejemplares")
	public Ejemplar insertEjemplar(@RequestBody Ejemplar ejemplar) {
		return ejemplarService.insertEjemplar(ejemplar);
	}
}
