package com.sopra.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub.model.Usuario;

@Repository
public interface RolRepository extends CrudRepository<Usuario, Long> {

}
