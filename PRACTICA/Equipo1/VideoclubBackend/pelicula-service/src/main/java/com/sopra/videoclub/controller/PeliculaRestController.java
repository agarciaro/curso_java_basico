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

import com.sopra.videoclub.model.Pelicula;
import com.sopra.videoclub.service.PeliculaService;

@RestController
@RequestMapping("/api")
public class PeliculaRestController {

	@Autowired
	PeliculaService peliculaService;;

	@GetMapping("/peliculas")
	public List<Pelicula> getAllPeliculas() {
		return peliculaService.findAllPeliculas();
	}

	@GetMapping("/peliculas/{id}")
	public Pelicula getPeliculaById(@PathVariable Integer id) throws NoSuchElementException {
		return peliculaService.findPeliculaById(id);
	}

	@PutMapping("/peliculas/{id}")
	public Pelicula updatePeliculaById(@PathVariable Integer id, @RequestBody Pelicula pelicula) {
		pelicula.setId(id);
		return peliculaService.updatePelicula(pelicula);
	}

	@PostMapping("/peliculas")
	public Pelicula insertPelicula(@Valid @RequestBody Pelicula pelicula) {
		return peliculaService.insertPelicula(pelicula);
	}

	@DeleteMapping("/peliculas/{id}")
	public void deletePeliculaById(@PathVariable Integer id) {
		peliculaService.deletePelicula(id);
	}

}
