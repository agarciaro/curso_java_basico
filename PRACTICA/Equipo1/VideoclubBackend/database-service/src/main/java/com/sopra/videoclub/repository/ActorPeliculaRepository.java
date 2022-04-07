package com.sopra.videoclub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub.model.ActorPelicula;

@Repository
public interface ActorPeliculaRepository extends JpaRepository<ActorPelicula, Integer> {

	List<ActorPelicula> findByActorId(Integer id);

}
