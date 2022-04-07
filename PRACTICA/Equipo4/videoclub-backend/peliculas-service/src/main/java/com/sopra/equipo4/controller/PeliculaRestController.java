package com.sopra.equipo4.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.equipo4.model.Pelicula;
import com.sopra.equipo4.service.PeliculaService;

@RestController
@RequestMapping("/api")
public class PeliculaRestController {

	@Autowired
	PeliculaService peliculaService;
	
	@GetMapping("/peliculas")
	public List<Pelicula> getAllPeliculas() {
		return peliculaService.getAllPeliculas();
	}
	
	@GetMapping("/peliculas/pagination")
	public List<Pelicula> getPreviewPeliculas(Pageable pageable) {
		return peliculaService.paginatedOrderByName(pageable);
	}
	
	@GetMapping("/peliculas/{id}")
	public Pelicula getPeliculaById(@PathVariable Integer id) {
		return peliculaService.getPeliculaById(id);
	}
	
	@PostMapping("/peliculas")
	public Pelicula insert(@RequestBody Pelicula pelicula) {
		return peliculaService.insert(pelicula);
	}
	
	@PutMapping("/peliculas")
	public Pelicula update(@RequestBody Pelicula pelicula) {
		return peliculaService.update(pelicula);
	}
	
	@DeleteMapping("/peliculas/{id}")
	public String delete(@PathVariable Integer id) {
		return peliculaService.delete(id) ? "Se ha eliminado con éxito" : "Ha ocurrido un error al eliminar.";
	}
	
	
}
