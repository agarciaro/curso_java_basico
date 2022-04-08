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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;

@RestController
@RequestMapping("/api")
public class ActorRestController {
	@Autowired
	ActorService actorService;

	@Operation(summary = "Retorna todos los actores registrados")
	@GetMapping("/actor")
	public List<Actor> getAllDirectors() {
		return actorService.findAll();
	}

	@Operation(summary = "Retorna todos los actores registrados dado un codigo de actor valido")
	@Parameters({@Parameter(name = "id", required = true, description = "El codigo de actor")})
	@GetMapping("/actor/{id}")
	public Actor getDirector(@PathVariable Long id) {
		return actorService.findById(id);
	}
	
	@Operation(summary = "Inserta los datos en la BBDD de actor")
	@PostMapping("/actor")
	public Actor insertActor(@RequestBody Actor actor) {
		return actorService.insert(actor);
	}

	@Operation(summary = "Actualiza los datos en la BBDD de director")
	@PutMapping("/actor")
	public Actor updateDirector(@RequestBody Actor actor) {
		return actorService.update(actor);
	}

	@Operation(summary = "Elimina los datos en la BBDD de actor dado un codigo de actor valido")
	@Parameters({@Parameter(name = "id", required = true, description = "El codigo de actor")})
	@DeleteMapping("/actor/{id}")
	public void deleteActor(@PathVariable Long id) {
		actorService.delete(id);
	}
	
	@Operation(summary = "Retorna todos los actores que intervienen en la pelicula dado un codigo de pelicula valido")
	@Parameters({@Parameter(name = "id", required = true, description = "El codigo de pelicula")})
	@GetMapping("/pelicula/{id}/actor")
	public List<Actor> getAllActoresByPelicula(@PathVariable Long id) {
		return actorService.findActoresByPelicula(id);
	}

}
