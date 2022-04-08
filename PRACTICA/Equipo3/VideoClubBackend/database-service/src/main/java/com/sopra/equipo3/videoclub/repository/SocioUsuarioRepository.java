package com.sopra.equipo3.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipo3.videoclub.model.entity.SocioUsuario;

@Repository
public interface SocioUsuarioRepository extends CrudRepository<SocioUsuario, Long>{

}
