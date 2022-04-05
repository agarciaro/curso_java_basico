package com.sopra.equipo3.videoclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.equipo3.videoclub.model.Pelicula;
import com.sopra.equipo3.videoclub.repository.PeliculaRepository;

@Service
public class PeliculaServiceImp implements PeliculaService {

	@Autowired
	PeliculaRepository peliculaRepository;

	@Override
	public List<Pelicula> findAll() {
		
		return peliculaRepository.findAll();
	}

	@Override
	public List<Pelicula> findAllByDirector(Long id) {
		return null;
	}

	@Override
	public Pelicula findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pelicula insert(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

	@Override
	public Pelicula update(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}



}
