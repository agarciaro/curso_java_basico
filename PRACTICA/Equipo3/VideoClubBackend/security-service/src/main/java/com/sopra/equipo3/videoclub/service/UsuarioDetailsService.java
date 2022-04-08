package com.sopra.equipo3.videoclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sopra.equipo3.videoclub.model.UsuarioDetails;
import com.sopra.equipo3.videoclub.model.entity.Usuario;
import com.sopra.equipo3.videoclub.repository.UsuarioRepository;


@Service

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
