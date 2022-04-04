package com.sopra.biblioteca.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.biblioteca.model.Soci;
import com.sopra.biblioteca.service.SocisService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(description = "Gestión de los socis de la biblioteca"))
@RestController
@RequestMapping("/api")
public class SocisRestController {
	
	@Autowired
	SocisService socisService;
	
	@Operation(summary = "Retorna todos los socios registrados")
	@GetMapping("/socis")
	@PreAuthorize("hasRole('SOCI')")
	public List<Soci> getAllSocis(){
		return socisService.findAll();
	}
	
	@Operation(summary = "Retorna todos los socios registrados dado un código de soci válido")
	@Parameters({
		@Parameter(name = "codi", required = true, description = "El código del soci")
	})
	@GetMapping("/socis/{codi}")
	public Soci getSociByCodi(@PathVariable Integer codi) throws NoSuchElementException {
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
	
	@DeleteMapping("/socis/{codi}")
	public void deleteSociByCodi(@PathVariable Integer codi) {
		socisService.delete(codi);
	}
	
}
