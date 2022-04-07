package com.sopra.videoclub5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.videoclub5.modelEntity.Usuario;
import com.sopra.videoclub5.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Usuario newUsuario(Usuario usuario) {
		return usuario;
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

}
