package com.sopra.biblioteca.reporsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.biblioteca.model.Prestec;

@Repository
public interface PrestecRepository extends CrudRepository<Prestec, Integer>{

}
