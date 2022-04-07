package com.sopra.equipoa.videoclub.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipoa.videoclub.model.entity.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

	Page<Pelicula> findByTituloIgnoreCaseContaining(  Pageable oPageable, String nombre);
	
	Page<Pelicula> findByDirectoresId(Pageable oPageable, Long idDirector);
	

}
