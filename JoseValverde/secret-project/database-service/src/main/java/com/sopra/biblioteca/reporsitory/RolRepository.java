package com.sopra.biblioteca.reporsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.biblioteca.model.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, String> {

}
