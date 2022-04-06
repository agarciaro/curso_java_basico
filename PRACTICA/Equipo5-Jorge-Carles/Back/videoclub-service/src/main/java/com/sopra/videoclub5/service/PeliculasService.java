package com.sopra.videoclub5.service;

import java.util.List;

import com.sopra.videoclub5.model.Pelicula;

public interface PeliculasService {

	public List<Pelicula> findAll();

	public Pelicula findById(Integer id);

	public void deleteById(Integer id);

	public Pelicula update(Pelicula pelicula);

	public Pelicula insert(Pelicula pelicula);

	List<Pelicula> find10();
}
