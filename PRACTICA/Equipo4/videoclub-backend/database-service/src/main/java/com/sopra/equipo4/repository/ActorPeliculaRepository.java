package com.sopra.equipo4.repository;

import org.springframework.data.repository.CrudRepository;

import com.sopra.equipo4.model.ActorPelicula;
import com.sopra.equipo4.model.ActorPeliculaPK;

public interface ActorPeliculaRepository extends CrudRepository<ActorPelicula, ActorPeliculaPK> {

}
