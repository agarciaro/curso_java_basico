package com.sopra.equipo3.videoclub.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sopra.equipo3.videoclub.model.Pelicula;
import com.sopra.equipo3.videoclub.repository.PeliculaRepository;

@Service
@Transactional
public class PeliculaServiceImp implements PeliculaService {

	@Autowired
	PeliculaRepository peliculaRepository;

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
	public Pelicula findById(Long id) {
		return peliculaRepository.findById(id).get();
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




}
