package com.sopra.biblioteca.reporsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.biblioteca.Socis;

@Repository
public interface SocisRepository extends CrudRepository<Socis, Integer> {
	
	
	
}
