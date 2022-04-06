package com.sopra.equipo3.videoclub.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sopra.equipo3.videoclub.model.Pelicula;

public interface PeliculaService {
		
	public Page<Pelicula> findAllPeliculas(Pageable pageable);
	
	public Page<Pelicula> findAllFilter(Pageable pageable, String filter);
	
	public Page<Pelicula> findAllByDirector(Pageable oPageable, Long idDirector);
	
	
	public Pelicula findById(Long id);
	 
	public Pelicula insert(Pelicula pelicula);

	public Pelicula update(Pelicula pelicula);

	public void delete(Long id);
}
