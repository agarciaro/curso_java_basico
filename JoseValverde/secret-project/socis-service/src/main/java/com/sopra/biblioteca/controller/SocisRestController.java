package com.sopra.biblioteca.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.biblioteca.model.Soci;
import com.sopra.biblioteca.service.SocisService;

@RestController
@RequestMapping("/api")
public class SocisRestController {
	
	@Autowired
	SocisService socisService;
	
	@GetMapping("/socis")
	public Set<Soci> getAllSocis(){
		return socisService.findAll();
	}
	
	@GetMapping("/socis/{codi}")
	public Soci getSociByCodi(@PathVariable Integer codi) {
		return socisService.findByCodi(codi);
	}
	
	@PutMapping("/socis/{codi}")
	public Soci updateSociByCodi(@PathVariable Integer codi, @RequestBody Soci soci) {
		soci.setCodi(codi);
		return socisService.update(soci);
	}
	
	@PostMapping("/socis")
	public Soci insertSoci(@Valid @RequestBody Soci soci) {
		return socisService.insert(soci);
	}
	
}
