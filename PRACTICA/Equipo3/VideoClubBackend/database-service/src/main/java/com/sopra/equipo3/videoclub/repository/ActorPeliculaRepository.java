package com.sopra.equipo3.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipo3.videoclub.model.ActorPelicula;
import com.sopra.equipo3.videoclub.model.ActorPeliculaPK;

@Repository
public interface ActorPeliculaRepository extends CrudRepository<ActorPelicula, ActorPeliculaPK> {

}
