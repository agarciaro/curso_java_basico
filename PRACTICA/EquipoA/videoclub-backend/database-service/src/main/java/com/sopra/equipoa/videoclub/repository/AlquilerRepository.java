package com.sopra.equipoa.videoclub.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipoa.videoclub.model.entity.Alquiler;
import com.sopra.equipoa.videoclub.model.entity.AlquilerPK;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, AlquilerPK> {

}
