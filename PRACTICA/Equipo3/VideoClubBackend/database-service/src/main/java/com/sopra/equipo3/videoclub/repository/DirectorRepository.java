package com.sopra.equipo3.videoclub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sopra.equipo3.videoclub.model.Actor;
import com.sopra.equipo3.videoclub.model.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {


	List<Director> findByPeliculasId(Long id);
	
}
