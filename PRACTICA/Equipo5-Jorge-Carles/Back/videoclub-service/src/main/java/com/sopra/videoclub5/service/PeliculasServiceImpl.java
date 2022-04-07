package com.sopra.videoclub5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.videoclub5.model.Pelicula;
import com.sopra.videoclub5.repository.PeliculaRepository;

@Service
public class PeliculasServiceImpl implements PeliculasService {

	@Autowired
	PeliculaRepository peliculasRepository;

	@Override
	public List<Pelicula> find10() {

		return (List<Pelicula>) peliculasRepository.findAll();
	}

	@Override
	public Pelicula findById(Integer id) {

		return peliculasRepository.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		peliculasRepository.deleteById(id);
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
