package com.sopra.videoclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.videoclub.model.Pelicula;
import com.sopra.videoclub.repository.PeliculaRepository;

@Service
public class PeliculasServiceImpl implements PeliculaService {

	@Autowired
	PeliculaRepository peliculasRepository;

	@Override
	public List<Pelicula> findAll() {
		return (List<Pelicula>) peliculasRepository.findAll();
	}

	@Override
	public Pelicula findById(Integer id) {
		return peliculasRepository.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		peliculasRepository.deleteById(id);
		;
	}

	@Override
	public Pelicula update(Pelicula pelicula) {
		return peliculasRepository.save(pelicula);
	}

	@Override
	public Pelicula insert(Pelicula pelicula) {
		return peliculasRepository.save(pelicula);
	}
	
	

}
