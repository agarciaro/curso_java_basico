package com.sopra.equipo4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.equipo4.model.Director;
import com.sopra.equipo4.repository.DirectorRepository;

@Service
public class DirectorServiceImpl implements DirectorService {
	
	@Autowired
	DirectorRepository directorRepository;

	@Override
	public List<Director> getAllDirectores() {
		return (List<Director>) directorRepository.findAll();
	}

	@Override
	public Director getDirectorById(Integer id) {
		return directorRepository.findById(id).get();
	}

	@Override
	public Director insert(Director director) {
		return directorRepository.save(director);
	}

	@Override
	public Director update(Director director) {
		return directorRepository.save(director);
	}

	@Override
	public boolean delete(Integer id) {
		
		directorRepository.deleteById(id);
		
		return directorRepository.findById(id).isEmpty() ? true : false;
	}
	
}
