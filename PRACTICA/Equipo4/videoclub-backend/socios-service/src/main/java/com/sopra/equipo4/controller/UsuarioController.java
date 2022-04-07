package com.sopra.equipo4.controller;

import java.util.ArrayList;

import com.sopra.equipo4.model.JwtToken;
import com.sopra.equipo4.repository.UsuarioRepository;
import com.sopra.equipo4.service.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserDetailsService userDetailsService;


    @GetMapping("/login")
	public JwtToken login(@RequestParam(required = true) String username, @RequestParam(required = true) String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		String token= jwtTokenUtil.generateToken(userDetails);		
		
		return new JwtToken(token, username, new ArrayList<>());
	}
}
