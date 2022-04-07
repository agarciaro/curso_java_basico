package com.sopra.equipoa.videoclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.equipoa.videoclub.model.Paginable;
import com.sopra.equipoa.videoclub.model.entity.Pelicula;
import com.sopra.equipoa.videoclub.repository.PeliculaRepository;

@RestController
@RequestMapping("/api")
public class PeliculaController {
	
	@Autowired
	PeliculaRepository peliculaRepository;
	
//	@Autowired
//	Pagina pagina;
	
	@GetMapping("/peliculas")
	public Page<Pelicula> getPeliculas(Paginable pagina){
		return peliculaRepository.findAll(pagina);
	}
	
}
