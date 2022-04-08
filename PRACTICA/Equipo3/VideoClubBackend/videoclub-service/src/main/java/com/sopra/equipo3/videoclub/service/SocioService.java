package com.sopra.equipo3.videoclub.service;

import java.util.List;

import com.sopra.equipo3.videoclub.model.entity.Socio;

public interface SocioService {
	public List<Socio> findAll();

	public Socio findById(Long id);

	public Socio insert(Socio socio);

	public Socio update(Socio socio);

	public void delete(Long id);

}
