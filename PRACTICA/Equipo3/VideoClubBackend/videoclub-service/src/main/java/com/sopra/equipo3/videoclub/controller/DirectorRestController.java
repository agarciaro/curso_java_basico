package com.sopra.equipo3.videoclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.equipo3.videoclub.model.entity.Director;
import com.sopra.equipo3.videoclub.service.DirectorService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.info.Info;

import java.util.List;

@OpenAPIDefinition(info = @Info(description="Gestion de las API del videoclub"))
@RestController
@RequestMapping("/api/director")
public class DirectorRestController {

	@Autowired
	DirectorService directorService;

	@Operation(summary = "Retorna todos los directores registrados")
	@GetMapping()
	public List<Director> getAllDirectors() {
		return directorService.findAll();
	}

	@Operation(summary = "Retorna todos los directores registrados dado un codigo de director valido")
	@Parameters({@Parameter(name = "id", required = true, description = "El codigo de director")})
	@GetMapping("/{id}")
	public Director getDirector(@PathVariable Long id) {
		return directorService.findById(id);
	}

	@Operation(summary = "Inserta los datos en la BBDD de director")
	@PostMapping()
	public Director insertDirector(@RequestBody Director director) {
		return directorService.insert(director);
	}

	@Operation(summary = "Actualiza los datos en la BBDD de director")
	@PutMapping()
	public Director updateDirector(@RequestBody Director director) {
		return directorService.update(director);
	}

	@Operation(summary = "Elimina los datos en la BBDD de director dado un codigo de director valido")
	@Parameters({@Parameter(name = "id", required = true, description = "El codigo de director")})
	@DeleteMapping("/{id}")
	public void deleteDirector(@PathVariable Long id) {
		directorService.delete(id);
	}

}
