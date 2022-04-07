package com.sopra.equipoa.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipoa.videoclub.model.entity.Pelicula;

@Repository
public interface PeliculaRepository extends PagingAndSortingRepository<Pelicula, Long>, CrudRepository<Pelicula, Long> {
	

}
