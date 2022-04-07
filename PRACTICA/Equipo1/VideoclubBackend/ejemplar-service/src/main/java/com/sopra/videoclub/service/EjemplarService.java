package com.sopra.videoclub.service;

import java.util.List;

import com.sopra.videoclub.model.Ejemplar;

public interface EjemplarService {

	public List<Ejemplar> findAllEjemplares();

	public Ejemplar findEjemplarById(Integer id);

	public void deleteEjemplar(Integer id);

	public Ejemplar updateEjemplar(Ejemplar ejemplar);

	public Ejemplar insertEjemplar(Ejemplar ejemplar);

}