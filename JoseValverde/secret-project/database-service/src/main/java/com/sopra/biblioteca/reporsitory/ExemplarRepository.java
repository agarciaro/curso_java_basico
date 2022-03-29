package com.sopra.biblioteca.reporsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.biblioteca.model.Exemplar;

@Repository
public interface ExemplarRepository extends CrudRepository<Exemplar, Integer>{
	
}
