package com.sopra.equipoa.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipoa.videoclub.model.entity.SocioUsuario;

@Repository
public interface SocioUsuarioRepository extends CrudRepository<SocioUsuario, Long>{

}
