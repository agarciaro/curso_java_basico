package com.sopra.videoclub5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub5.modelEntity.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {

}
