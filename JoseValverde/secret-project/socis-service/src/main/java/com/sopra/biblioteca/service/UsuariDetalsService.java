package com.sopra.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sopra.biblioteca.model.Usuari;
import com.sopra.biblioteca.model.UsuariDetails;
import com.sopra.biblioteca.reporsitory.UsuariRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuariDetalsService implements UserDetailsService {
	
	@Autowired
	UsuariRepository usuariRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuari usuari = usuariRepository.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException("El usuari " + username + " no se ha encontrado"));
		
		UsuariDetails usuariDetails = new UsuariDetails(usuari);
		
		return usuariDetails;
	}

}
