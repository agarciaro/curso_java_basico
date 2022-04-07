package com.sopra.equipo4.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipo4.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	public Usuario findByUsername(String username);
}
