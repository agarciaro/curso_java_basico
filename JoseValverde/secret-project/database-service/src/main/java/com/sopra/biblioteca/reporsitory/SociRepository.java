package com.sopra.biblioteca.reporsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.biblioteca.model.Soci;

@Repository
public interface SociRepository extends CrudRepository<Soci, Integer> {
	
	
	
}
