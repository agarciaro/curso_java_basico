package com.sopra.videoclub5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sopra.videoclub5.modelEntity.Pelicula;
import com.sopra.videoclub5.repository.PeliculaRepository;

@Service
public class PeliculasServiceImpl implements PeliculasService {

	@Autowired
	PeliculaRepository peliculasRepository;

	@Override
	public Page<Pelicula> findAll(PageRequest of) {
		return peliculasRepository.findAll(of);
	}

	@Override
	public List<Pelicula> findByTitulo(String titulo) {
		return (List<Pelicula>) peliculasRepository.findByTitulo(titulo);
	}



}
