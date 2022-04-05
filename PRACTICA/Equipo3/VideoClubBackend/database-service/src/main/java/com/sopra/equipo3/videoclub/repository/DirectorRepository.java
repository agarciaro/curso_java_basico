package com.sopra.equipo3.videoclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sopra.equipo3.videoclub.model.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

}
