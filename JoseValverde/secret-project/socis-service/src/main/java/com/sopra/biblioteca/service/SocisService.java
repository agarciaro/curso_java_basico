package com.sopra.biblioteca.service;

import java.util.List;

import com.sopra.biblioteca.model.Soci;

public interface SocisService {
	
	public List<Soci> findAll();
	public Soci findByCodi(Integer codi);
	public void delete(Integer codi);
	public Soci update(Soci soci);
	public Soci insert(Soci soci);
	
}
