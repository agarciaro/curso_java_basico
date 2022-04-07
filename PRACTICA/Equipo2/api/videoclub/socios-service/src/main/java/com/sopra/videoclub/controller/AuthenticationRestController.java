package com.sopra.videoclub.controller;

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

import com.sopra.videoclub.model.JwtToken;
import com.sopra.videoclub.model.Usuario;
import com.sopra.videoclub.model.UsuarioCredenciales;
import com.sopra.videoclub.service.JwtTokenUtil;
import com.sopra.videoclub.service.UsuarioService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthenticationRestController {

	@Autowired
	UsuarioService usuarioService;
	
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
	public JwtToken login(@RequestBody UsuarioCredenciales credencials) {
		log.info("{}",credencials);
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						credencials.getUsername(), credencials.getPassword()));
		UserDetails userDetails = userDetailsService.loadUserByUsername(credencials.getUsername());

		String token = jwtTokenUtil.generateToken(userDetails);

		return new JwtToken(token, userDetails.getUsername());
	}
//	
//	@PostMapping("/registro")
//	public Usuario registro(@RequestBody UsuarioCredenciales credencials) {
//		
//		return usuarioService.insert(new Usuario(credencials.getUsername(), credencials.getPassword(),null,null));
//	}

	@GetMapping("/password/{password}/encode")
	public String encodePassword(@PathVariable String password) {
		return encoder.encode(password);
	}
	
	

//	@GetMapping("/token/refresh")
//	public JwtToken refreshToken() {
//		String username = jwtTokenUtil.getUsuarioFromToken(jwtToken.getToken());
//		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//		return new JwtToken(jwtTokenUtil.generateToken(userDetails));
//	}

}
