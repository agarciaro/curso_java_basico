package com.sopra.videoclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.videoclub.model.Actor;
import com.sopra.videoclub.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService{
	
	@Autowired
	ActorRepository actorRepository;
	
	@Override
	public List<Actor> findAllActores() {
		return (List<Actor>) actorRepository.findAll();
	}

	@Override
	public Actor findActorById(Integer id) {
		return actorRepository.findById(id).get();
	}

	@Override
	public void deleteActor(Integer id) {
		actorRepository.deleteById(id);
		
	}

	@Override
	public Actor updateActor(Actor actor) {
		return actorRepository.save(actor);
	}

	@Override
	public Actor insertActor(Actor actor) {
		return actorRepository.save(actor);
	}

}
