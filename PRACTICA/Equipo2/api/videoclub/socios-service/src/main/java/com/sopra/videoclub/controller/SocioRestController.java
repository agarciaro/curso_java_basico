package com.sopra.videoclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		
		log.info("Socios {}",socioService.findAll());
		return socioService.findAll();
	}

}
