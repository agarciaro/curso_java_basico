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

import com.sopra.equipo3.videoclub.model.Pelicula;
import com.sopra.equipo3.videoclub.service.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaRestController {

	@Autowired
	PeliculaService peliculaService;

	@GetMapping()
	public List<Pelicula> getAllPeliculas() {
		return peliculaService.findAll();
	}

	@GetMapping("/{id}")
	public Pelicula getPelicula(@PathVariable Long id) {
		return peliculaService.findById(id);
	}

	@GetMapping("/director/{id}")
	public List<Pelicula> getAllByDirector(@PathVariable Long id){
		return peliculaService.findAllByDirector(id);
	}

	@PostMapping()
	public Pelicula getAllByDirector(@RequestBody Pelicula pelicula) {
		return peliculaService.insert(pelicula);
	}

	@PutMapping()
	public Pelicula updatePelicula(@RequestBody Pelicula pelicula) {
		return peliculaService.update(pelicula);
	}

	@DeleteMapping("/{id}")
	public void deletePelicula(@PathVariable Long id) {
		peliculaService.delete(id);
	}
}
