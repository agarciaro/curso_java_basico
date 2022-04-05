package com.sopra.videoclub5.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PapelActorKey implements Serializable {
	
	private Integer idPelicula;
	private Integer idActor;

}
