package com.sopra.equipo3.videoclub.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.equipo3.videoclub.model.Pelicula;
import com.sopra.equipo3.videoclub.repository.PeliculaRepository;

@Service
@Transactional
public class PeliculaServiceImp implements PeliculaService {

	@Autowired
	PeliculaRepository peliculaRepository;

	@Override
	public List<Pelicula> findAll() {
		
		return peliculaRepository.findAll();
	}

	@Override
	public List<Pelicula> findAllByDirector(Long id) {
		return peliculaRepository.findByDirectoresId(id);
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
