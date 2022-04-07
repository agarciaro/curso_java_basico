package com.sopra.videoclub.service;

import java.util.List;

import com.sopra.videoclub.model.Actor;

public interface ActorService {
	
	public List<Actor> findAllActores();
	public Actor findActorById(Integer id);
	public void deleteActor(Integer id);
	public Actor updateActor(Actor actor);
	public Actor insertActor(Actor actor);
	
	
	
	

}
