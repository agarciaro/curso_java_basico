package com.sopra.equipo4.repository;

import org.springframework.data.repository.CrudRepository;

import com.sopra.equipo4.model.Alquiler;
import com.sopra.equipo4.model.AlquilerPK;

public interface AlquilerRepository extends CrudRepository<Alquiler, AlquilerPK> {

}
