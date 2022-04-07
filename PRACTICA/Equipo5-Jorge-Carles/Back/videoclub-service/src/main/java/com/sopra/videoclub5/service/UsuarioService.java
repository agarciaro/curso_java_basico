package com.sopra.videoclub5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sopra.videoclub5.modelEntity.Usuario;

@Service
public interface UsuarioService {
	public Usuario newUsuario(Usuario usuario);

	public List<Usuario> findAll();

}
