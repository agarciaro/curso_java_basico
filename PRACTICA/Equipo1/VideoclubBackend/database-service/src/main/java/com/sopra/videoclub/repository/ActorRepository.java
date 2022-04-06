package com.sopra.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub.model.Actor;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer>{

}
