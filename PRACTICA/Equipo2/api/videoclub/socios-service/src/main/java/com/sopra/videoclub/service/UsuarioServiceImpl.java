package com.sopra.videoclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.videoclub.model.Usuario;
import com.sopra.videoclub.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	@Override
	public Usuario insert(Usuario usu) {
		
		return usuarioRepository.save(usu);
	}

}
