package com.sopra.equipo3.videoclub.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sopra.equipo3.videoclub.model.Actor;
import com.sopra.equipo3.videoclub.model.ActorPelicula;
import com.sopra.equipo3.videoclub.model.ActorPeliculaPK;
import com.sopra.equipo3.videoclub.model.Pelicula;

@Repository
public interface ActorPeliculaRepository extends JpaRepository<ActorPelicula, ActorPeliculaPK> {
	

}
