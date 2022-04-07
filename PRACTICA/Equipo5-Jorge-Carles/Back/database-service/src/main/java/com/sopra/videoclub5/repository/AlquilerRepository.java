package com.sopra.videoclub5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub5.modelEntity.Alquiler;
import com.sopra.videoclub5.modelEntity.AlquilerKey;

@Repository
public interface AlquilerRepository extends CrudRepository<Alquiler, AlquilerKey> {

}
