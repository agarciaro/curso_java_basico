package com.sopra.equipo4.controller;

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

import com.sopra.equipo4.model.Actor;
import com.sopra.equipo4.service.ActorService;

@RestController
@RequestMapping("/api")
public class ActorRestController {
	
	@Autowired
	ActorService actorService;
	
	@GetMapping("/actores")
	public List<Actor> getAllActores() {
		return actorService.getAllActores();
	}
	
	@GetMapping("/actores/{id}")
	public Actor getActorById(@PathVariable Integer id) {
		return actorService.getActorById(id);
	}
	
	@PostMapping("/actores")
	public Actor insert(@RequestBody Actor actor) {
		return actorService.insert(actor);
	}
	
	@PutMapping("/actores")
	public Actor update(@RequestBody Actor actor) {
		return actorService.update(actor);
	}
	
	@DeleteMapping("/actores/{id}")
	public String delete(@PathVariable Integer id) {
		return actorService.delete(id) ? "Se ha eliminado con éxito" : "Ha ocurrido un problema";
	}
}
