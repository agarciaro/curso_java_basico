package com.sopra.equipo1.videoclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sopra.equipo1.videoclub.model.UsuarioDetails;
import com.sopra.videoclub.model.Usuario;
import com.sopra.videoclub.repository.UsuarioRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario: " + username + " no encontrado");
		}
		UsuarioDetails usuarioDetails = new UsuarioDetails(usuario);
		return usuarioDetails;
	}
	
}