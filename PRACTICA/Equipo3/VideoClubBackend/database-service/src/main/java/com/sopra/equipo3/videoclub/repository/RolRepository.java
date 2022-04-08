package com.sopra.equipo3.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipo3.videoclub.model.entity.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long>{
	public Rol findByNombre(String nombre);
}
