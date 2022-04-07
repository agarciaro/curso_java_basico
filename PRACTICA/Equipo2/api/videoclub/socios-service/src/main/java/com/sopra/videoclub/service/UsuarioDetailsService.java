package com.sopra.videoclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sopra.videoclub.model.Usuario;
import com.sopra.videoclub.model.UsuarioDetails;
import com.sopra.videoclub.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioDetailsService implements UserDetailsService{
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException("El usuario"+ username +"no se ha encontrado" ));
				
		UsuarioDetails usuarioDetails = new UsuarioDetails(usuario);
		return usuarioDetails;
	}
	

}
