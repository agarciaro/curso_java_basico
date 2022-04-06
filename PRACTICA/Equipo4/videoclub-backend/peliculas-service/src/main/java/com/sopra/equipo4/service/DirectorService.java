package com.sopra.equipo4.service;

import java.util.List;

import com.sopra.equipo4.model.Director;

public interface DirectorService {
	
	public List<Director> getAllDirectores();
	public Director getDirectorById(Integer id);
	public Director insert(Director director);
	public Director update(Director director);
	public boolean delete(Integer id);
}
