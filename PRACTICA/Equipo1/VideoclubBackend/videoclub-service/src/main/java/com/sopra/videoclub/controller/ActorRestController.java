package com.sopra.videoclub.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.videoclub.model.Actor;
import com.sopra.videoclub.service.ActorService;

@RestController
@RequestMapping("/api")
public class ActorRestController {
	
	@Autowired
	ActorService actorService;;
	
	@GetMapping("/actores")
	public List<Actor> getAllActores(){
		return actorService.findAllActores();
	}
	
	@GetMapping("/actores/{id}")
	public Actor getActorById(@PathVariable Integer id) throws NoSuchElementException {
		return actorService.findActorById(id);
	}
	
	@PutMapping("/actores/{id}")
	public Actor updateActorById(@PathVariable Integer id, @RequestBody Actor actor) {
		actor.setId(id);
		return actorService.updateActor(actor);
	}
	
	@PostMapping("/actores")
	public Actor insertActor(@Valid @RequestBody Actor actor) {
		return actorService.insertActor(actor);
	}
	
	@DeleteMapping("/actores/{id}")
	public void deleteActorById(@PathVariable Integer id) {
		actorService.deleteActor(id);
	}
	
	
	

}
