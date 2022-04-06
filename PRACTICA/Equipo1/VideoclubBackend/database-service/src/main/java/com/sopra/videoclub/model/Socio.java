package com.sopra.videoclub.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Socio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false, unique = true)
	private String dni;
	@Column(nullable=false)
	private String nombre;
	private String direccion;
	private String telefono;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "arendado", 
			joinColumns = @JoinColumn(referencedColumnName = "id_pelicula"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "id_actor")
	)
	
	private Set<Pelicula> peliculas = new HashSet<>();

	

}
