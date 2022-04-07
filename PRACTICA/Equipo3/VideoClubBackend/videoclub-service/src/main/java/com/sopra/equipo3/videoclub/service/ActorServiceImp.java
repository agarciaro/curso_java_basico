package com.sopra.equipo3.videoclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.equipo3.videoclub.model.Actor;
import com.sopra.equipo3.videoclub.repository.ActorRepository;

@Service
public class ActorServiceImp implements ActorService{
	
	@Autowired
	ActorRepository actorRepository;
	@Override
	public List<Actor> findAll() {
		return actorRepository.findAll();
	}

	@Override
	public Actor findById(Long id) {
		return actorRepository.findById(id).get();
	}

	@Override
	public Actor insert(Actor actor) {
		return actorRepository.save(actor);
	}

	@Override
	public Actor update(Actor actor) {
		return actorRepository.save(actor);
	}

	@Override
	public void delete(Long id) {
		 actorRepository.deleteById(id);
		
	}

	@Override
	public List<Actor> findActoresByPelicula(Long id) {
		return findActoresByPelicula(id);
	}

}
