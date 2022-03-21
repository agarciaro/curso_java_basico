package com.sopra.spring.prueba.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.spring.prueba.model.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer>{
	
	public List<Persona> findByNombre(String nombre);

}
