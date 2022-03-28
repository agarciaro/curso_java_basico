package com.sopra.biblioteca.reporsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.biblioteca.model.Llibre;

@Repository
public interface LlibreRepository extends CrudRepository<Llibre, Integer>{
	
}
