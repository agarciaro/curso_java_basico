package com.sopra.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.spring.model.Socis;
import com.sopra.spring.service.SocisService;

@RestController
@RequestMapping("/api/socis")
public class SocisRestController {
	
	@Autowired
	SocisService socisService;
	
	@GetMapping
	List<Socis> getAllSocis(){
		return socisService.getSocis();
	}
	
	@PostMapping
	Socis insertSoci(@RequestBody Socis soci) {
		return socisService.insert(soci);
	}
	
}
