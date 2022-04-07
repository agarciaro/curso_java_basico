package com.sopra.videoclub5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub5.modelEntity.Director;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Integer> {

}
