package com.sopra.videoclub5.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


//Tabla intermedia entre Pelicula y Actor

public class ParticipaEn {
	
	@ManyToOne
	@JoinColumn(name = "id_pelicula", nullable = false)
	private Pelicula idPelicula;
	
	@ManyToOne
	@JoinColumn(name = "id_actor", nullable = false)
	private Actor idActor;

}
