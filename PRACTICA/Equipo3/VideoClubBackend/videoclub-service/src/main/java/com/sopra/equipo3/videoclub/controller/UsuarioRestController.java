package com.sopra.equipo3.videoclub.controller;

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

import java.util.stream.Collectors;

import javax.validation.Valid;

import com.sopra.equipo3.videoclub.model.JwtToken;
import com.sopra.equipo3.videoclub.model.DTO.DatosRegistroDto;
import com.sopra.equipo3.videoclub.model.DTO.LoginDto;
import com.sopra.equipo3.videoclub.model.entity.Usuario;
import com.sopra.equipo3.videoclub.service.JwtTokenUtil;
import com.sopra.equipo3.videoclub.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
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
	
	@PostMapping("/login")
	public JwtToken login(@RequestBody @Valid LoginDto logindto) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logindto.getUsername(), logindto.getPassword()));
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(logindto.getUsername());
		String token= jwtTokenUtil.generateToken(userDetails);		
		
		return new JwtToken(token, logindto.getUsername(), ((Usuario) userDetails).getRoles().stream().map((rol -> rol.getNombre())).collect(Collectors.toList()));
	}
	
	@PostMapping("/registro")
	public String registro(@RequestBody @Valid DatosRegistroDto datosRegistro) {
		return usuarioService.registro(datosRegistro).getUsername();
	}
}
