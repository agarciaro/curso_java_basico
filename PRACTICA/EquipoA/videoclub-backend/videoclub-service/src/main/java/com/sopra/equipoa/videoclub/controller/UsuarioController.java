package com.sopra.equipoa.videoclub.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.equipoa.videoclub.model.JwtToken;
import com.sopra.equipoa.videoclub.model.DatosRegistroDto;
import com.sopra.equipoa.videoclub.model.entity.Usuario;
import com.sopra.equipoa.videoclub.service.JwtTokenUtil;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	UserDetailsService userDetailsService;
	
//	@Autowired
//	PasswordEncoder encoder;
//	
//	@Autowired
//	JwtToken jwtToken;
	
	@GetMapping("/login")
	public JwtToken login(@RequestParam(required = true) String username, @RequestParam(required = true) String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		String token= jwtTokenUtil.generateToken(userDetails);		
		
		return new JwtToken(token, username, new ArrayList<>());
	}
	
	@PostMapping("/registro")
	public Usuario registro(@RequestBody @Valid DatosRegistroDto datosRegistro) {
		return new Usuario("usuario1", "password");
	}
}
