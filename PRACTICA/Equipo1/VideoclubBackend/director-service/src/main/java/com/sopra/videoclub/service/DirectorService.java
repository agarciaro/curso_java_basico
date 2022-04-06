package com.sopra.videoclub.service;

import java.util.List;

import com.sopra.videoclub.model.Director;

public interface DirectorService {

	public List<Director> findAllDirectores();

	public Director findDirectorById(Integer id);

	public void deleteDirector(Integer id);

	public Director updateDirector(Director director);

	public Director insertDirector(Director director);

}