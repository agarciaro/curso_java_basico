package com.sopra.equipo3.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipo3.videoclub.model.Socio;

@Repository
public interface SocioRepository  extends CrudRepository<Socio, Long>{

}
