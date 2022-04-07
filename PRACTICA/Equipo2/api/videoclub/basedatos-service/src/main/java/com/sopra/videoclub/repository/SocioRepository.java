package com.sopra.videoclub.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub.model.Socio;

@Repository
public interface SocioRepository extends CrudRepository<Socio, Integer>{

	@Query("SELECT c.socioId FROM CodigoInvitacion c WHERE c.codigo = :codigo")
	public Integer getCodigoSocio(@Param("codigo") String codigo);
}
