package com.sopra.equipo3.videoclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sopra.equipo3.videoclub.model.Director;
import com.sopra.equipo3.videoclub.service.DirectorService;

import java.util.List;

@RestController
@RequestMapping("/api/director")
public class DirectorRestController {
	
	@Autowired
	DirectorService directorService;
	
	@GetMapping("/")
	public List<Director> getAllDirectors(){
		return directorService.findAll();
	}
	
	@PostMapping("/")
	public Director insertDirector(@RequestBody Director director){
		return directorService.insert(director);
	}
	

}
