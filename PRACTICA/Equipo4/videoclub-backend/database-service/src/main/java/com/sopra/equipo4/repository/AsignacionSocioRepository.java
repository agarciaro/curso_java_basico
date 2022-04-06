package com.sopra.equipo4.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipo4.model.AsignacionSocio;

@Repository
public interface AsignacionSocioRepository extends CrudRepository<AsignacionSocio, Integer> {
	
//	@Query("INSERT INTO AsignacionSocio(id_socio, codigo) VALUES (:id_socio, :codigo)")
//	public AsignacionSocio insert(@Param("id_socio") Integer id_socio, @Param("codigo") String codigo);
}
