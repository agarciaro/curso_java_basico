package com.sopra.videoclub.service;

import com.sopra.videoclub.model.RegisterDetailsDto;
import com.sopra.videoclub.model.Usuario;

public interface UsuarioService {

	public Usuario insert(RegisterDetailsDto registroDetails);
}
