package com.sopra.equipo3.videoclub.service;

import java.util.List;

import com.sopra.equipo3.videoclub.model.entity.Ejemplar;

public interface EjemplarService {
	public List<Ejemplar> findAll();

	public Ejemplar findById(Long id);

	public Ejemplar insert(Ejemplar ejemplar);

	public Ejemplar update(Ejemplar ejemplar);

	public void delete(Long id);
}
