package com.sopra.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub.model.ActorPelicula;

@Repository
public interface ActorPeliculaRepository extends CrudRepository<ActorPelicula, Integer>{

}
