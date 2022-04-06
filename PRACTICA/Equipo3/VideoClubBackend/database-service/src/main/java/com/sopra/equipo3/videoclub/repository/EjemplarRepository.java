package com.sopra.equipo3.videoclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipo3.videoclub.model.Ejemplar;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar, Long>{

}
