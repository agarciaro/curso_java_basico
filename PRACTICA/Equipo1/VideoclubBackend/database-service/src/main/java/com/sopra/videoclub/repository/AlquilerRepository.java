package com.sopra.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub.model.Alquiler;

@Repository
public interface AlquilerRepository extends CrudRepository<Alquiler, Integer> {

}
