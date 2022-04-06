package com.sopra.equipo3.videoclub.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipo3.videoclub.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

	Page<Pelicula> findByTituloIgnoreCaseContaining(  Pageable oPageable, String nombre);
	
	Page<Pelicula> findByDirectoresId(Pageable oPageable, Long idDirector);
	

}
