package com.sopra.equipo3.videoclub.service;

import java.util.List;

import com.sopra.equipo3.videoclub.model.Actor;

public interface ActorService {
	
	public List<Actor> findAll();

	public Actor findById(Long id);

	public Actor insert(Actor actor);

	public Actor update(Actor actor);

	public void delete(Long id);

}
