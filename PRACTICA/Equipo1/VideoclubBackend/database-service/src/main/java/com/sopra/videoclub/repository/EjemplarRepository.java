package com.sopra.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub.model.Ejemplar;

@Repository
public interface EjemplarRepository extends CrudRepository<Ejemplar, Integer> {

}
