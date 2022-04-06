package com.sopra.equipo4.service;

import java.util.List;

import com.sopra.equipo4.model.Ejemplar;

public interface EjemplarService {
	
	public List<Ejemplar> findAll();
	public Ejemplar findById(Integer id);
	public void deleteEjemplarById(Integer id);
	public Ejemplar updateEjemplar(Ejemplar ejemplar);
	public Ejemplar insertEjemplar(Ejemplar ejemplar);
	
}
