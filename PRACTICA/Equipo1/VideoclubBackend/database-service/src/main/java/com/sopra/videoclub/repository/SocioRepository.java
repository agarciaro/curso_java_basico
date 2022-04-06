package com.sopra.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub.model.Socio;

@Repository
public interface SocioRepository extends CrudRepository<Socio, Integer>{

}
