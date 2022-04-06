package com.sopra.videoclub5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub5.model.PeliculaActor;
import com.sopra.videoclub5.model.PeliculaActorKey;

@Repository
public interface PeliculaActorRepository extends CrudRepository<PeliculaActor,PeliculaActorKey > {

}
