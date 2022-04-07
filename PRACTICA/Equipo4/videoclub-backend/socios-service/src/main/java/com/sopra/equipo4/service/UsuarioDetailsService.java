package com.sopra.equipo4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sopra.equipo4.model.Usuario;
import com.sopra.equipo4.model.UsuarioDetails;
import com.sopra.equipo4.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("El usuario: " + username + " no ha sido encontrado");
		}
		
		UsuarioDetails usuarioDetails = new UsuarioDetails(usuario);
		
		return usuarioDetails;
	}

}
