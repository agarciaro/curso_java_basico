package com.sopra.equipo4.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.sopra.equipo4.model.Pelicula;

public interface PeliculaService {
	
	public List<Pelicula> getAllPeliculas();
	public List<Pelicula> paginatedOrderByName(Pageable pageable);
	public Pelicula getPeliculaById(Integer id);
	public Pelicula insert(Pelicula pelicula);
	public Pelicula update(Pelicula pelicula);
	public boolean delete(Integer id);
}
