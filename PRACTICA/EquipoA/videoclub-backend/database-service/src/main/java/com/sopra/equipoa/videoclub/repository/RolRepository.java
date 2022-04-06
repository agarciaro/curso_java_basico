package com.sopra.equipoa.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipoa.videoclub.model.entity.Usuario;

@Repository
public interface RolRepository extends CrudRepository<Usuario, Long>{

}
