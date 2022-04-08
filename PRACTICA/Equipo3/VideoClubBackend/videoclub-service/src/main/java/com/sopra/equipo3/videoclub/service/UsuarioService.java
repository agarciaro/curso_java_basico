package com.sopra.equipo3.videoclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.equipo3.videoclub.model.DTO.DatosRegistroDto;
import com.sopra.equipo3.videoclub.model.entity.Invitacion;
import com.sopra.equipo3.videoclub.model.entity.Socio;
import com.sopra.equipo3.videoclub.model.entity.SocioUsuario;
import com.sopra.equipo3.videoclub.model.entity.Usuario;
import com.sopra.equipo3.videoclub.repository.InvitacionRepository;
import com.sopra.equipo3.videoclub.repository.RolRepository;
import com.sopra.equipo3.videoclub.repository.SocioUsuarioRepository;
import com.sopra.equipo3.videoclub.repository.UsuarioRepository;

@Service
public class UsuarioService {
		
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	InvitacionRepository invitacionRepository;
	
	@Autowired
	SocioUsuarioRepository socioUsuarioRepository;
	
	@Autowired
	RolRepository rolRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Transactional(rollbackFor = Exception.class)
	public Usuario registro(DatosRegistroDto datos) {
		
		//Comprobar que el usuario no existe
		if(null != usuarioRepository.findByUsername(datos.getUsername())) {
			throw new DuplicateKeyException("El usuario ya existe");
		}
		
		//Extraer el socio de la invitación
		Invitacion invitacion = invitacionRepository.findByCodigo(datos.getCodigoInvitacion());
		if(invitacion == null) {
			throw new RuntimeException("El código de invitación no es correcto");
		}
		Socio socio = invitacion.getSocio();
		
		//Comprobar que no tiene usuario asociado y crear dicho usuario
		Usuario usuario = new Usuario(datos.getUsername(), passwordEncoder.encode(datos.getPassword()));
		usuario.getRoles().add(rolRepository.findByNombre("SOCIO"));
		
		//Vincular socio al usuario
		usuario.setSocioUsuario(new SocioUsuario(socio.getId(), socio, usuario));
		
		//Guardar usuario
		usuarioRepository.save(usuario);
		
		//Eliminar la invitacion
		invitacionRepository.delete(invitacion);
		
		return usuario;
	}
	
}
