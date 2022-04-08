package com.sopra.equipo3.videoclub.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sopra.equipo3.videoclub.model.entity.ActorPelicula;
import com.sopra.equipo3.videoclub.model.entity.ActorPeliculaPK;
import com.sopra.equipo3.videoclub.model.entity.Pelicula;
import com.sopra.equipo3.videoclub.model.entity.PeliculaDatos;

public interface PeliculaService {
		
	public Page<Pelicula> findAllPeliculas(Pageable pageable);
	
	public Page<Pelicula> findAllFilter(Pageable pageable, String filter);
	
	public Page<Pelicula> findAllByDirector(Pageable oPageable, Long idDirector);
	
	public Page<Pelicula> findByActor(Pageable oPageable, Long idActor);
	
	public PeliculaDatos findById(Long id);
	 
	public Pelicula insert(Pelicula pelicula);

	public Pelicula update(Pelicula pelicula);

	public void delete(Long id);
}
