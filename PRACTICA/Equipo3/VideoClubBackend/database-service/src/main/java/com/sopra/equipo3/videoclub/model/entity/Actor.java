package com.sopra.equipo3.videoclub.model.entity;


import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String nacionalidad;
	private String sexo;
	private String urlImage;
	
	
	@OneToMany(mappedBy = "pelicula")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<ActorPelicula> actorPelicula;
}