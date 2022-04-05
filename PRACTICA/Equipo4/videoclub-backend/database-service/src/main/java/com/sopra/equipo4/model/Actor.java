package com.sopra.equipo4.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public abstract class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String nacionalidad;
	private String sexo;
	
	@ManyToMany(mappedBy = "actores")
	private Set<Pelicula> actuadoEn;
//	private String rol;
	
}
