package com.sopra.videoclub.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ejemplar {

	@Id
	private Integer numEjemplar;
	private String estadoCon;
	
	
//	private Pelicula pelicula;
}
