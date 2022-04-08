package com.sopra.equipo3.videoclub.service;

import java.util.List;

import com.sopra.equipo3.videoclub.model.entity.Director;

public interface DirectorService {

	public List<Director> findAll();

	public Director findById(Long id);

	public Director insert(Director director);

	public Director update(Director director);

	public void delete(Long id);

}
