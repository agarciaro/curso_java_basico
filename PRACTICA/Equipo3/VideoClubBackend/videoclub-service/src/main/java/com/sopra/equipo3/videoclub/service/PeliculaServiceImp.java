package com.sopra.equipo3.videoclub.service;

import java.util.Arrays;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sopra.equipo3.videoclub.model.entity.ActorPelicula;
import com.sopra.equipo3.videoclub.model.entity.ActorPeliculaPK;
import com.sopra.equipo3.videoclub.model.entity.Pelicula;
import com.sopra.equipo3.videoclub.model.entity.PeliculaDatos;
import com.sopra.equipo3.videoclub.repository.ActorPeliculaRepository;
import com.sopra.equipo3.videoclub.repository.ActorRepository;
import com.sopra.equipo3.videoclub.repository.DirectorRepository;
import com.sopra.equipo3.videoclub.repository.PeliculaRepository;

@Service
@Transactional
public class PeliculaServiceImp implements PeliculaService {

	@Autowired
	PeliculaRepository peliculaRepository;
	@Autowired
	ActorRepository actorRepository;
	@Autowired
	DirectorRepository directorRepository;
	@Autowired
	ActorPeliculaRepository actorPeliculaRepository;
	
	@Override
	public Page<Pelicula> findAllPeliculas(Pageable pageable) {
		
		return peliculaRepository.findAll( pageable);
	}

	@Override
	public Page<Pelicula> findAllFilter(Pageable pageable, String filter) {
		
		return peliculaRepository.findByTituloIgnoreCaseContaining( pageable,  filter);
	}

	@Override
	public Page<Pelicula> findAllByDirector(Pageable pageable, Long idDirector) {
		return peliculaRepository.findByDirectoresId( pageable ,idDirector);
	}

	@Override
	public PeliculaDatos findById(Long id) {
		PeliculaDatos peliculaDatos = new PeliculaDatos ();
		peliculaDatos.setPelicula(peliculaRepository.findById(id).get());
		peliculaDatos.setActores(actorRepository.findByPeliculaId(id));
		peliculaDatos.setDirectores(directorRepository.findByPeliculasId(id));
		return peliculaDatos;
	}

	@Override
	public Pelicula insert(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

	@Override
	public Pelicula update(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

	@Override
	public void delete(Long id) {
		peliculaRepository.deleteById(id);

	}

	@Override
	public Page<Pelicula> findByActor(Pageable pageable, Long idActor) {
		return peliculaRepository.findByActorId(pageable, idActor);
	}





}
