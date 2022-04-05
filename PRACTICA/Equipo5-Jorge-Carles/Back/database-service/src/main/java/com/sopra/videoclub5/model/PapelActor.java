package com.sopra.videoclub5.model;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PapelActor {
	
	@EmbeddedId
	PapelActorKey id;
	
	@ManyToOne
	@JoinColumn()

}
