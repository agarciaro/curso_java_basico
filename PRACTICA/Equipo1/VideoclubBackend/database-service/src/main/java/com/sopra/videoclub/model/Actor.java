package com.sopra.videoclub.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_actor;
//	@Column(nullable = false)
	@NotNull
	
	private String nombre;
	private String nacionalidad;
	private String sexo;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "actor_pelicula", 
			joinColumns = @JoinColumn(referencedColumnName = "id_pelicula"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "id_actor")
	)
	private Set<Pelicula> peliculas = new HashSet<>();

}