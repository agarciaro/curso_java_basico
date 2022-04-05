package com.sopra.videoclub5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub5.model.Actor;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {

}
