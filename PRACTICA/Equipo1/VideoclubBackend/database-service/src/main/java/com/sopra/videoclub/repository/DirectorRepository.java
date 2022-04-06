package com.sopra.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub.model.Director;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Integer>{

}
