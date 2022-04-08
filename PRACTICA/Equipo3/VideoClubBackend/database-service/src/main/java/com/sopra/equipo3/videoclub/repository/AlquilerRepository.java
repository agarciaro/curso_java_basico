package com.sopra.equipo3.videoclub.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipo3.videoclub.model.entity.Alquiler;
import com.sopra.equipo3.videoclub.model.entity.AlquilerPK;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, AlquilerPK> {

}
