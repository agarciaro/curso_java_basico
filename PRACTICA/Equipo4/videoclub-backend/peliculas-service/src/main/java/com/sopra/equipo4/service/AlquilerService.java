package com.sopra.equipo4.service;

import java.util.List;

import com.sopra.equipo4.model.Alquiler;
import com.sopra.equipo4.model.AlquilerPK;

public interface AlquilerService {
	
	public List<Alquiler> findAll();
	public Alquiler findById(AlquilerPK id);
	public void deleteAlquilerById(AlquilerPK id);
	public Alquiler updateAlquiler(Alquiler alquiler);
	public Alquiler insertAlquiler(Alquiler alquiler);
	
}
