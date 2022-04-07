package com.sopra.equipoa.videoclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.equipoa.videoclub.model.entity.Invitacion;

@Repository
public interface InvitacionRepository extends CrudRepository<Invitacion, Long> {

	Invitacion findByCodigo(String codigoInvitacion);

}
