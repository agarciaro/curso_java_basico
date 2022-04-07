package com.sopra.equipo4.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sopra.equipo4.model.Pelicula;

public interface PeliculaRepository extends CrudRepository<Pelicula, Integer> {

	@Query(value = "SELECT p FROM Pelicula p ORDER BY p.titulo DESC")
	public List<Pelicula> paginatedOrderByName(Pageable pageable);
}
