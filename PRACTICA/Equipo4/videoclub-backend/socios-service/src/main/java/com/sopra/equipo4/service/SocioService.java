package com.sopra.equipo4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sopra.equipo4.model.Socio;

public interface SocioService {
	
	public List<Socio> findAll();
	public Socio findById(Integer id);
	public void deleteSocioById(Integer id);
	public Socio updateSocio(Socio socio);
	public Socio insertSocio(Socio socio);
	
}
