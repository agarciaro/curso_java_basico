package com.sopra.equipoa.videoclub.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.equipoa.videoclub.model.JwtToken;
import com.sopra.equipoa.videoclub.model.RegistroDto;
import com.sopra.equipoa.videoclub.model.entity.Usuario;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@GetMapping("/login")
	public JwtToken login(@RequestParam(required = true) String username, @RequestParam(required = true) String password) {
		return new JwtToken("asdasdasda", new ArrayList<>());
	}
	
	@PostMapping("/registro")
	public Usuario registro(@RequestBody RegistroDto datosRegistro) {
		return new Usuario("usuario1", "password");
	}
}
