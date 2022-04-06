package com.sopra.equipo3.videoclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipo3.videoclub.model.ActorPelicula;
import com.sopra.equipo3.videoclub.model.ActorPeliculaPK;

@Repository
public interface ActorPeliculaRepository extends JpaRepository<ActorPelicula, ActorPeliculaPK> {

}
