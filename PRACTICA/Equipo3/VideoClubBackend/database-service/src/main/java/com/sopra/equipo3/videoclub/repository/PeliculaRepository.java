package com.sopra.equipo3.videoclub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sopra.equipo3.videoclub.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

	List<Pelicula> findByDirectoresId(Long idDirector);
	

}
