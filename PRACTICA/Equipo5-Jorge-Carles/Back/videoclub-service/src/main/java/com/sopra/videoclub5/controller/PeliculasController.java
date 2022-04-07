package com.sopra.videoclub5.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.videoclub5.modelEntity.Pelicula;
import com.sopra.videoclub5.repository.PeliculaRepository;
import com.sopra.videoclub5.service.PeliculasService;

@RestController
@RequestMapping("/api")
public class PeliculasController {
	@Autowired
	PeliculasService peliculasService;

	@GetMapping("/peliculas")
	public Page<Pelicula> getAllPeliculas(
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
		return peliculasService.findAll(PageRequest.of(page, size));
	}

	@GetMapping("/peliculas/{titulo}")
	public List<Pelicula> getPeliculasByNombre(@PathVariable String titulo) throws NoSuchElementException {
		return peliculasService.findByTitulo(titulo);

	}

}
