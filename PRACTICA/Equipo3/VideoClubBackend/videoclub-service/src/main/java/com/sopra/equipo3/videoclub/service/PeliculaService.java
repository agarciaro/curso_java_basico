package com.sopra.equipo3.videoclub.service;

import java.util.List;
import com.sopra.equipo3.videoclub.model.Pelicula;

public interface PeliculaService {
	
	public List<Pelicula> findAll();
	
	public List<Pelicula> findAllByDirector(Long id);
	
	public Pelicula findById(Long id);
	 
	public Pelicula insert(Pelicula pelicula);

	public Pelicula update(Pelicula pelicula);

	public void delete(Long id);
}
