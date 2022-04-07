package com.sopra.videoclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub.model.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {

}
