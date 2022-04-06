package com.sopra.equipoa.videoclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sopra.equipoa.videoclub.model.UsuarioDetails;
import com.sopra.equipoa.videoclub.model.entity.Usuario;
import com.sopra.equipoa.videoclub.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioDetailsService implements UserDetailsService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("El usuario " + username + " no se ha encontrado");
		}

		UsuarioDetails usuariDetails = new UsuarioDetails(usuario);
		
		return usuariDetails;
	}

}
