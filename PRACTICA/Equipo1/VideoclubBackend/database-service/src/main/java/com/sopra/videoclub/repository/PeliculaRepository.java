package com.sopra.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sopra.videoclub.model.Pelicula;

@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula, Integer>{

}
