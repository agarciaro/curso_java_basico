package com.sopra.videoclub.controller;

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

import com.sopra.videoclub.model.Pelicula;
import com.sopra.videoclub.service.PeliculaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class PeliculasRestController{

	@Autowired
	PeliculaService peliculaService;
	
	@GetMapping("/peliculas")
	public List<Pelicula> getAll(){
		return peliculaService.findAll();
	}
	
	@GetMapping("/peliculas/{id}")
	public Pelicula findPelicula(@PathVariable Integer id){
		Pelicula peli =peliculaService.findById(id);
		log.info("peli{}",peli.getEjemplares());
		return peliculaService.findById(id);
	}
	@PostMapping("/peliculas")
	public Pelicula insertPelicula(@RequestBody Pelicula pelicula) {
		return peliculaService.insert(pelicula);
	}
	
	@PutMapping("/peliculas/{id}")
	public Pelicula updatePelicula(@PathVariable Integer id, @RequestBody Pelicula pelicula) {
		pelicula.setId(id);
		return peliculaService.update(pelicula);
	}
	
	@DeleteMapping("/peliculas/{id}")
	public void deletePelicula(@PathVariable Integer id) {
		peliculaService.delete(id);
	}
	
	
}
