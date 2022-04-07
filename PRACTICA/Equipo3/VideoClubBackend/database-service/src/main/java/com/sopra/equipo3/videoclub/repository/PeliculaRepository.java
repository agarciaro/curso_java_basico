package com.sopra.equipo3.videoclub.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sopra.equipo3.videoclub.model.Actor;
import com.sopra.equipo3.videoclub.model.ActorPelicula;
import com.sopra.equipo3.videoclub.model.ActorPeliculaPK;
import com.sopra.equipo3.videoclub.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

	Page<Pelicula> findByTituloIgnoreCaseContaining(  Pageable pageable, String nombre);
	
	Page<Pelicula> findByDirectoresId(Pageable pageable, Long idDirector);
	

	@Query("SELECT p "
			+ "FROM Pelicula p "
			+ "LEFT JOIN ActorPelicula  actPel "
			+ "ON p.id = actPel.id.idPelicula "
			+ "where  actPel.id.idActor  = :id ")
	Page<Pelicula> findByActorId(Pageable pageable, @Param("id") Long actorId);

}
