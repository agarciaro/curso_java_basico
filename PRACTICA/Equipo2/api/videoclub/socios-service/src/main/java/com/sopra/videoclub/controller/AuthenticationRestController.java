package com.sopra.videoclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.model.JwtToken;
import com.sopra.model.UsuarioDetails;
import com.sopra.videoclub.model.UsuarioCredenciales;
import com.sopra.videoclub.service.JwtTokenUtil;

@RestController
@RequestMapping("api/auth")
public class AuthenticationRestController {
//
////	@Autowired
////	AuthenticationManager authenticationManager;
//
//	@Autowired
//	JwtTokenUtil jwtTokenUtil;
//
//	@Autowired
//	UserDetailsService userDetailsService;
//
//	@Autowired
//	PasswordEncoder encoder;
//
//	@Autowired
//	JwtToken jwtToken;
//
//	@PostMapping("/logging")
//	public JwtToken login(@RequestBody UsuarioCredenciales credenciales) {
//		authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(credenciales.getUsername(), credenciales.getPassword()));
//		UsuarioDetails usuarioDetails = (UsuarioDetails) userDetailsService
//				.loadUserByUsername(credenciales.getUsername());	
//		String token = jwtTokenUtil.generateToken(usuarioDetails);
//		
//		return new JwtToken(token);
//	}
//	
//	@GetMapping("/password/{password}/encode")
//	public String encodePassword(@PathVariable String password) {
//		return encoder.encode(password);
//	}
//	
//	@GetMapping("/token/refresh")
//	public JwtToken refreshToken() {
//		String username = jwtTokenUtil.getUsuarioFromToken(jwtToken.getToken());
//		UsuarioDetails usuarioDetails = (UsuarioDetails) userDetailsService.loadUserByUsername(username);
//		return new JwtToken(jwtTokenUtil.generateToken(usuarioDetails));
//	}
}
