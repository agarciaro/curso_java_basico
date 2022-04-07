package com.sopra.videoclub5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sopra.videoclub5.model.UsuarioDetails;
import com.sopra.videoclub5.modelEntity.Usuario;
import com.sopra.videoclub5.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioDetailsService implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("El usuario " + username + " no se ha encontrado");
		}

		UsuarioDetails usuariDetails = new UsuarioDetails(usuario);

		return usuariDetails;
	}

}
