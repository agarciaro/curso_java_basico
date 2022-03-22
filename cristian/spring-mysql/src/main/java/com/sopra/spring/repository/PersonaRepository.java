package com.sopra.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.spring.model.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
