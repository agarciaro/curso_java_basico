package com.sopra.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.biblioteca.model.JwtToken;
import com.sopra.biblioteca.model.UsuariCredencials;
import com.sopra.biblioteca.service.JwtTokenUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationRestController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtToken jwtToken;
	
	@PostMapping("/login")
	public JwtToken login(@RequestBody UsuariCredencials credencials) {
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						credencials.getUsername(), credencials.getPassword()
				)
		);
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(credencials.getUsername());
		String token= jwtTokenUtil.generateToken(userDetails);		
		
		return new JwtToken(token);
	}
	
	@GetMapping("/password/{password}/encode")
	public String encodePassword(@PathVariable String password) {
		return encoder.encode(password);
	}
	
	@GetMapping("/token/refresh")
	public JwtToken refreshToken() {
		String username = jwtTokenUtil.getUsernameFromToken(jwtToken.getToken());
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		return new JwtToken(jwtTokenUtil.generateToken(userDetails));
	}
	
}
