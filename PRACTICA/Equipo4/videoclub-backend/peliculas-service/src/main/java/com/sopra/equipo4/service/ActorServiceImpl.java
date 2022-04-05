package com.sopra.equipo4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.equipo4.model.Actor;
import com.sopra.equipo4.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {
	
	@Autowired
	ActorRepository actorRepository;

	@Override
	public List<Actor> getAllActores() {
		return (List<Actor>) actorRepository.findAll();
	}

	@Override
	public Actor getActorById(Integer id) {
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
	public boolean delete(Integer id) {
		
		actorRepository.deleteById(id);
		
		return actorRepository.findById(id).isEmpty() ? true : false;
	}

}
