package com.sopra.equipo3.videoclub.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sopra.equipo3.videoclub.model.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

	@Query("SELECT a "
			+ "FROM Actor a "
			+ "LEFT JOIN ActorPelicula  actPel "
			+ "ON a.id = actPel.id.idActor "
			+ "where  actPel.id.idPelicula  = :id ")
	List<Actor> findByPeliculaId(@Param("id") Long id);

	
}
