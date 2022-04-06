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

import com.sopra.videoclub.model.Director;
import com.sopra.videoclub.service.DirectorService;

@RestController
@RequestMapping("/api")
public class DirectorRestController {

	@Autowired
	DirectorService directorService;;

	@GetMapping("/directores")
	public List<Director> getAllDirectores() {
		return directorService.findAllDirectores();
	}

	@GetMapping("/directores/{id}")
	public Director getDirectorById(@PathVariable Integer id) throws NoSuchElementException {
		return directorService.findDirectorById(id);
	}

	@PutMapping("/directores/{id}")
	public Director updateDirectorById(@PathVariable Integer id, @RequestBody Director director) {
		director.setId(id);
		return directorService.updateDirector(director);
	}

	@PostMapping("/directores")
	public Director insertDirector(@Valid @RequestBody Director director) {
		return directorService.insertDirector(director);
	}

	@DeleteMapping("/directores/{id}")
	public void deleteDirectorById(@PathVariable Integer id) {
		directorService.deleteDirector(id);
	}

}