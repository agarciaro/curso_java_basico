package com.sopra.equipo3.videoclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.equipo3.videoclub.model.entity.ActorPelicula;
import com.sopra.equipo3.videoclub.model.entity.Pelicula;
import com.sopra.equipo3.videoclub.model.entity.PeliculaDatos;
import com.sopra.equipo3.videoclub.service.PeliculaService;

@RestController
@RequestMapping("/api")
public class PeliculaRestController {

	@Autowired
	PeliculaService peliculaService;

	@GetMapping("/peliculas")
	public Page<Pelicula> getAllPeliculas(
			@PageableDefault(page = 0, size = 8, direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam(name = "filter", required = false) String filter) {
		return filter != null ? peliculaService.findAllFilter(pageable, filter)
				: peliculaService.findAllPeliculas(pageable);
	}

	@GetMapping("/peliculas/{id}")
	public PeliculaDatos getPelicula(@PathVariable Long id) {
		return peliculaService.findById(id);
	}

	@GetMapping("/director/peliculas")
	public Page<Pelicula> getAllByDirector(
			@PageableDefault(page = 0, size = 8, direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam(name = "id", required = false) Long id) {
		return peliculaService.findAllByDirector(pageable, id);
	}
	
	@GetMapping("/actor/peliculas/")
	public Page<Pelicula> getAllByActor(
			@PageableDefault(page = 0, size = 8, direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam(name = "id", required = false)  Long id) {
		return peliculaService.findByActor(pageable, id);
	}

	@PostMapping("/peliculas")
	public Pelicula getAllByDirector(@RequestBody Pelicula pelicula) {
		return peliculaService.insert(pelicula);
	}

	@PutMapping("/peliculas")
	public Pelicula updatePelicula(@RequestBody Pelicula pelicula) {
		return peliculaService.update(pelicula);
	}

	@DeleteMapping("/peliculas/{id}")
	public void deletePelicula(@PathVariable Long id) {
		peliculaService.delete(id);
	}
}
