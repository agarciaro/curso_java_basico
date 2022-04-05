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

import com.sopra.equipo4.model.Director;
import com.sopra.equipo4.service.DirectorService;

@RestController
@RequestMapping("/api")
public class DirectorRestController {
	
	@Autowired
	DirectorService directorService;
	
	@GetMapping("/directores")
	public List<Director> getAllDirectores() {
		return directorService.getAllDirectores();
	}
	
	@GetMapping("/directores/{id}")
	public Director getDirectorById(@PathVariable Integer id) {
		return directorService.getDirectorById(id);
	}
	
	@PostMapping("/directores")
	public Director insert(@RequestBody Director director) {
		return directorService.insert(director);
	}
	
	@PutMapping("/directores")
	public Director update(@RequestBody Director director) {
		return directorService.update(director);
	}
	
	@DeleteMapping("/directores/{id}")
	public String delete(@PathVariable Integer id) {
		return directorService.delete(id) ? "Se ha eliminado con éxito" : "Ha ocurrido un error";
	}

}
