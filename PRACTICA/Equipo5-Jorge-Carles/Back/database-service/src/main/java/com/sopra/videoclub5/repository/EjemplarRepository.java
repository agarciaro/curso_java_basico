package com.sopra.videoclub5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub5.modelEntity.Ejemplar;

@Repository
public interface EjemplarRepository extends CrudRepository<Ejemplar, Integer> {

}
