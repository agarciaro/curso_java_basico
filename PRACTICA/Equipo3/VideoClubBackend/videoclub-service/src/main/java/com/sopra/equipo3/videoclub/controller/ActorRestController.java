package com.sopra.equipo3.videoclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.equipo3.videoclub.model.entity.Actor;
import com.sopra.equipo3.videoclub.service.ActorService;

@RestController
@RequestMapping("/api")
public class ActorRestController {
	@Autowired
	ActorService actorService;

	@GetMapping("/actor")
	public List<Actor> getAllDirectors() {
		return actorService.findAll();
	}

	@GetMapping("/actor/{id}")
	public Actor getDirector(@PathVariable Long id) {
		return actorService.findById(id);
	}

	@PostMapping("/actor")
	public Actor insertActor(@RequestBody Actor actor) {
		return actorService.insert(actor);
	}

	@PutMapping("/actor")
	public Actor updateDirector(@RequestBody Actor actor) {
		return actorService.update(actor);
	}

	@DeleteMapping("/actor/{id}")
	public void deleteActor(@PathVariable Long id) {
		actorService.delete(id);
	}
	
	@GetMapping("/pelicula/{id}/actor")
	public List<Actor> getAllActoresByPelicula(@PathVariable Long id) {
		return actorService.findActoresByPelicula(id);
	}

}
