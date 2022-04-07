package com.sopra.videoclub.service;

import java.util.List;

import com.sopra.videoclub.model.Socio;


public interface SocioService {

	public List<Socio> findAll();
	public Socio findById(Integer id);
	public Socio insertSocio(Socio socio);
	public Socio updateSocio(Socio socio);
	public void deleteSocio(Integer id);
	public Integer getSocioCodigo(String codigo);
	
}
