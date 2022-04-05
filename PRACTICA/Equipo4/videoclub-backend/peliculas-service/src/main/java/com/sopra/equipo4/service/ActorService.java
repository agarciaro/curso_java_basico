package com.sopra.equipo4.service;

import java.util.List;

import com.sopra.equipo4.model.Actor;

public interface ActorService {

	public List<Actor> getAllActores();
	public Actor getActorById(Integer id);
	public Actor insert(Actor actor);
	public Actor update(Actor actor);
	public boolean delete(Integer id);
}
