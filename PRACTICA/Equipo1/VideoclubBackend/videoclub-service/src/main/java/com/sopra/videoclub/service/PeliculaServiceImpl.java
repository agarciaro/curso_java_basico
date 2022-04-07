package com.sopra.videoclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sopra.videoclub.model.Pelicula;
import com.sopra.videoclub.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService {

	@Autowired
	PeliculaRepository peliculaRepository;

	@Override
	public List<Pelicula> findAllPeliculas() {
		return (List<Pelicula>) peliculaRepository.findAll();
	}

	@Override
	public Pelicula findPeliculaById(Integer id) {
		return peliculaRepository.findById(id).get();
	}

	@Override
	public void deletePelicula(Integer id) {
		peliculaRepository.deleteById(id);

	}

	@Override
	public Pelicula updatePelicula(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

	@Override
	public Pelicula insertPelicula(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

}