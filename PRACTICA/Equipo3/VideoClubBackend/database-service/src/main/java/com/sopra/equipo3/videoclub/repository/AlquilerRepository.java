package com.sopra.equipo3.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipo3.videoclub.model.Alquiler;
import com.sopra.equipo3.videoclub.model.AlquilerPK;

@Repository
public interface AlquilerRepository extends CrudRepository<Alquiler, AlquilerPK> {

}
