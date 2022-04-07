package com.sopra.equipo4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sopra.equipo4.model.Pelicula;
import com.sopra.equipo4.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService {
	
	@Autowired
	PeliculaRepository  peliculaRepository;

	@Override
	public List<Pelicula> getAllPeliculas() {
		return (List<Pelicula>) peliculaRepository.findAll();
	}

	@Override
	public Pelicula getPeliculaById(Integer id) {
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
	public boolean delete(Integer id) {
		peliculaRepository.deleteById(id);
		
		return peliculaRepository.findById(id).isEmpty() ? true : false;
	}

	@Override
	public List<Pelicula> paginatedOrderByName(Pageable pageable) {
		return peliculaRepository.paginatedOrderByName(pageable);
	}

}
