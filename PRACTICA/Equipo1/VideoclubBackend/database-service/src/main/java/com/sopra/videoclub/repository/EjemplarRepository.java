package com.sopra.videoclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub.model.Ejemplar;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar, Integer> {

}
