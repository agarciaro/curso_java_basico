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

import com.sopra.videoclub.model.Ejemplar;
import com.sopra.videoclub.service.EjemplarService;

@RestController
@RequestMapping("/api")
public class EjemplarRestController {

	@Autowired
	EjemplarService ejemplarService;;

	@GetMapping("/ejemplares")
	public List<Ejemplar> getAllEjemplares() {
		return ejemplarService.findAllEjemplares();
	}

	@GetMapping("/ejemplares/{id}")
	public Ejemplar getEjemplarById(@PathVariable Integer id) throws NoSuchElementException {
		return ejemplarService.findEjemplarById(id);
	}

	@PutMapping("/ejemplares/{id}")
	public Ejemplar updateEjemplarById(@PathVariable Integer numejemplar, @RequestBody Ejemplar ejemplar) {
		ejemplar.setNumEjemplar(numejemplar);
		return ejemplarService.updateEjemplar(ejemplar);
	}

	@PostMapping("/ejemplares")
	public Ejemplar insertEjemplar(@Valid @RequestBody Ejemplar ejemplar) {
		return ejemplarService.insertEjemplar(ejemplar);
	}

	@DeleteMapping("/ejemplares/{id}")
	public void deleteEjemplarById(@PathVariable Integer id) {
		ejemplarService.deleteEjemplar(id);
	}

}