package com.sopra.videoclub5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub5.modelEntity.Socio;

@Repository
public interface SocioRepository extends CrudRepository<Socio, Integer> {

}
