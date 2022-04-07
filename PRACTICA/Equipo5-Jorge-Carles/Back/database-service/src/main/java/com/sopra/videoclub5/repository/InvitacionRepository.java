package com.sopra.videoclub5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sopra.videoclub5.modelEntity.Invitacion;
import com.sopra.videoclub5.modelEntity.InvitacionKey;

@Repository
public interface InvitacionRepository extends CrudRepository<Invitacion, InvitacionKey> {

}
