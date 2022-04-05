package com.sopra.equipo3.videoclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.equipo3.videoclub.model.Director;
import com.sopra.equipo3.videoclub.repository.DirectorRepository;

@Service
public class DirectorServiceImp implements DirectorService {

	@Autowired
	DirectorRepository directorRepository;

	@Override
	public List<Director> findAll() {
		return directorRepository.findAll();

	}

	@Override
	public Director findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Director insert(Director director) {
		return directorRepository.save(director);
	}

	@Override
	public Director update(Director director) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
