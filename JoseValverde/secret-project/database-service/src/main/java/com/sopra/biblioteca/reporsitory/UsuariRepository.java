package com.sopra.biblioteca.reporsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.biblioteca.model.Usuari;

@Repository
public interface UsuariRepository extends CrudRepository<Usuari, String> {

}
