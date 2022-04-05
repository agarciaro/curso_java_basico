package com.sopra.videoclub.service;

import java.util.List;

import com.sopra.videoclub.model.Pelicula;

public interface PeliculaService {

	public List<Pelicula> findAll();

	public Pelicula findById(Integer id);

	public void delete(Integer id);

	public Pelicula update(Pelicula pelicula);
	
	public Pelicula insert(Pelicula pelicula);
}
