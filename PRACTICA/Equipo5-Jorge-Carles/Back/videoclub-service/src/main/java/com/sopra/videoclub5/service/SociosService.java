package com.sopra.videoclub5.service;

import java.util.List;

import com.sopra.videoclub5.model.Socio;

public interface SociosService {

	public List<Socio> findAll();

	public Socio findByNumSocio(Integer codi);

	public void delete(Integer codi);

	public Socio update(Socio soci);

	public Socio insert(Socio soci);

}
