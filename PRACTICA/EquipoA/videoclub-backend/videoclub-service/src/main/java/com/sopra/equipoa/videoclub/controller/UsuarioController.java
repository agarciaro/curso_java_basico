package com.sopra.equipoa.videoclub.controller;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
import com.sopra.equipoa.videoclub.UsuarioService;
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
	
	@Autowired
	UsuarioService usuarioService;
	
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
		
		return new JwtToken(token, username, ((Usuario) userDetails).getRoles().stream().map((rol -> rol.getNombre())).collect(Collectors.toList()));
	}
	
	@PostMapping("/registro")
	public String registro(@RequestBody @Valid DatosRegistroDto datosRegistro) {
		return usuarioService.registro(datosRegistro).getUsername();
	}
}
