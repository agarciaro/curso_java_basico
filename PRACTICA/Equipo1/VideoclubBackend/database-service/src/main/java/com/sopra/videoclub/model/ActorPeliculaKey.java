package com.sopra.videoclub.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ActorPeliculaKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_actor")
	private Integer idActor;
	@Column(name = "id_pelicula")
	private Integer idPelicula;
}


