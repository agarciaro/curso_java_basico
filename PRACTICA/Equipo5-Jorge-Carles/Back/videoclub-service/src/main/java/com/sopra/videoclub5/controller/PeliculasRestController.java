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

import com.sopra.videoclub5.model.Pelicula;
import com.sopra.videoclub5.service.PeliculasService;

@RestController
@RequestMapping("/api")
public class PeliculasRestController {
	@Autowired
	PeliculasService peliculasService;

	@GetMapping("/peliculas")
	public List<Pelicula> getAllPeliculas() {
		return peliculasService.findAll();
	}

	@GetMapping("/peliculas/{id}")
	public Pelicula getPeliculasById(@PathVariable Integer id) throws NoSuchElementException {
		return peliculasService.findById(id);

	}

	@DeleteMapping("/peliculas/{id}")
	public void deletePelicula(@PathVariable Integer id) throws NoSuchElementException {
		peliculasService.deleteById(id);
	}

	@PostMapping("/peliculas")
	public Pelicula insertPelicula(@Validated @RequestBody Pelicula pelicula) {
		return peliculasService.insert(pelicula);
	}

	@PutMapping("/peliculas/{id}")
	public Pelicula updateById(@PathVariable Integer id, @RequestBody Pelicula pelicula) {
		return peliculasService.update(pelicula);
	}
}
