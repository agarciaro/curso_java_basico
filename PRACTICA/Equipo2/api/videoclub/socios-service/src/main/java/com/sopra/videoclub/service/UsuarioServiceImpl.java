package com.sopra.videoclub.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.videoclub.model.RegisterDetailsDto;
import com.sopra.videoclub.model.Rol;
import com.sopra.videoclub.model.Socio;
import com.sopra.videoclub.model.Usuario;
import com.sopra.videoclub.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	SocioService socioService;
	
	@Override
	public Usuario insert(RegisterDetailsDto registerDetailsDto) {
		log.info("Detalles{}", registerDetailsDto);
		Set<Rol> roles = new HashSet<>();
		Integer id = socioService.getSocioCodigo(registerDetailsDto.getCodInvitacion());
		log.info("Id:{}", id);
		Socio socio = socioService.findById(id);
		
		Usuario usu = new Usuario(
				registerDetailsDto.getUsername(), 
				registerDetailsDto.getPassword(), 
				roles, socio);
		
		return usuarioRepository.save(usu);
	}

}
