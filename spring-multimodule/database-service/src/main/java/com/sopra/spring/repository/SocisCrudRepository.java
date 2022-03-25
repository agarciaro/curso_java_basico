package com.sopra.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.spring.model.Socis;

@Repository
public interface SocisCrudRepository extends CrudRepository<Socis, Integer>{

}
