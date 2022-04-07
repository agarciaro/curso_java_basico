package com.sopra.videoclub5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.videoclub5.modelEntity.Socio;
import com.sopra.videoclub5.modelEntity.Usuario;
import com.sopra.videoclub5.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> allUsuarios() {
		return usuarioService.findAll();
	}

	@PostMapping("/registro")
	public Usuario newUsuario(
			@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "password", required = true) String password) {
		return new Usuario(username, password);
	}
	
}
