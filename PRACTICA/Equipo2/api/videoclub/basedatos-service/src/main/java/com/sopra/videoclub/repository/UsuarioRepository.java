package com.sopra.videoclub.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,String>{

	
}
