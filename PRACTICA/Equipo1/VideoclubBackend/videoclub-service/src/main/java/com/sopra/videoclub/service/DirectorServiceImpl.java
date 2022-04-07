package com.sopra.videoclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.videoclub.model.Director;
import com.sopra.videoclub.repository.DirectorRepository;

@Service
public class DirectorServiceImpl implements DirectorService {

	@Autowired
	DirectorRepository directorRepository;

	@Override
	public List<Director> findAllDirectores() {
		return (List<Director>) directorRepository.findAll();
	}

	@Override
	public Director findDirectorById(Integer id) {
		return directorRepository.findById(id).get();
	}

	@Override
	public void deleteDirector(Integer id) {
		directorRepository.deleteById(id);

	}

	@Override
	public Director updateDirector(Director director) {
		return directorRepository.save(director);
	}

	@Override
	public Director insertDirector(Director director) {
		return directorRepository.save(director);
	}

}