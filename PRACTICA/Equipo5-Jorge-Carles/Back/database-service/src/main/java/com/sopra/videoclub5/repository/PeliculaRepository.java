package com.sopra.videoclub5.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub5.modelEntity.Pelicula;

@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula, Integer>, PagingAndSortingRepository<Pelicula, Integer> {

	List<Pelicula> findByTitulo(String titulo);

}
