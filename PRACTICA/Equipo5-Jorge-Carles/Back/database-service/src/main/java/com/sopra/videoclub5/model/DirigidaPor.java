package com.sopra.videoclub5.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//Tabla intermedia entre Pelicula y Director

public class DirigidaPor {
	@ManyToOne
	@JoinColumn(name = "id_director", nullable = false)
	private Director idDirector;
	
	@ManyToOne
	@JoinColumn(name = "id_pelicula", nullable = false)
	private Pelicula idPelicula;
}
