package com.sopra.videoclub.service;

import java.util.List;

import com.sopra.videoclub.model.Pelicula;

public interface PeliculaService {

	public List<Pelicula> findAllPeliculas();

	public Pelicula findPeliculaById(Integer id);

	public void deletePelicula(Integer id);

	public Pelicula updatePelicula(Pelicula pelicula);

	public Pelicula insertPelicula(Pelicula pelicula);

}