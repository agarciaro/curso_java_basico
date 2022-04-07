package com.sopra.videoclub.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Ejemplar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numEjemplar;
	private String estado;
	
	
	@ManyToOne
	@JoinColumn(name = "pelicula_id",referencedColumnName = "id")
	private Pelicula pelicula;
	
	@OneToMany(mappedBy = "ejemplar")
	private Set<Alquiler> socios;
}
