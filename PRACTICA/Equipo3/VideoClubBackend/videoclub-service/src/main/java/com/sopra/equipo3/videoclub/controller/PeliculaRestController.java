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

import com.sopra.equipo3.videoclub.model.Pelicula;
import com.sopra.equipo3.videoclub.service.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaRestController {

	@Autowired
	PeliculaService peliculaService;

	@GetMapping("/")
	public Page<Pelicula> getAllPeliculas(
			@PageableDefault(page = 0, size = 8, direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam(name = "filter", required = false) String filter) {
		return filter != null ? peliculaService.findAllFilter(pageable, filter)
				: peliculaService.findAllPeliculas(pageable);
	}

	@GetMapping("/{id}")
	public Pelicula getPelicula(@PathVariable Long id) {
		return peliculaService.findById(id);
	}

	@GetMapping("/director/{id}")
	public Page<Pelicula> getAllByDirector(
			@PageableDefault(page = 0, size = 8, direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam(name = "id", required = false) Long id) {
		return peliculaService.findAllByDirector(pageable, id);
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
