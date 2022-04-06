package com.sopra.equipoa.videoclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipoa.videoclub.model.entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

}
