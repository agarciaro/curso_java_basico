package com.sopra.videoclub5.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.sopra.videoclub5.modelEntity.Pelicula;

public interface PeliculasService {

	public Page<Pelicula> findAll(PageRequest of);

	public List<Pelicula> findByTitulo(String titulo);


}
