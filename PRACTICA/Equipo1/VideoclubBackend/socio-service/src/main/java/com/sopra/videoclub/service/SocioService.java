package com.sopra.videoclub.service;

import java.util.List;

import com.sopra.videoclub.model.Socio;

public interface SocioService {

	public List<Socio> findAllSocios();

	public Socio findSocioById(Integer id);

	public void deleteSocio(Integer id);

	public Socio updateSocio(Socio socio);

	public Socio insertSocio(Socio socio);

}