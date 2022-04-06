package com.sopra.videoclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.videoclub.model.Socio;
import com.sopra.videoclub.service.SocioService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class SocioRestController {
	
	@Autowired
	SocioService socioService;
	
	
	@GetMapping("/socios")
	public List<Socio> getAll(){
		
		return socioService.findAll();
	}
	
	@GetMapping("/socios/{id}")
	public Socio findById(@PathVariable("id") Integer id) {
		return socioService.findById(id);
	}
	
	@PostMapping("/socios")
	public Socio insertSocio(@RequestBody Socio socio) {
		return socioService.insertSocio(socio);
	}
	
	@PutMapping("/socios/{id}")
	public Socio updateSocio(@PathVariable("id")Integer id, @RequestBody Socio socio) {
		socio.setNumSocio(id);
		return socioService.updateSocio(socio);
	}
	
	@DeleteMapping("/socios/{id}")
	public void deleteSocio(@PathVariable("id")Integer id){
		socioService.deleteSocio(id);
	}

}
