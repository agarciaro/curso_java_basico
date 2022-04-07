package com.sopra.videoclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
