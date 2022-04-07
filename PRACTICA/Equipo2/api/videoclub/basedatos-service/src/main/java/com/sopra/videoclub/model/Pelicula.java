package com.sopra.videoclub.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String nacionalidad;
	private String productora;
	private LocalDate fecha;
	private String url;
	
	
	@OneToMany(mappedBy = "pelicula")
	@JsonIgnore
	private Set<PeliculaActor> actores;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "pelicula_director",
			joinColumns = @JoinColumn(name ="director_id", referencedColumnName = "id"),
			inverseJoinColumns =  @JoinColumn(name ="pelicula_id", referencedColumnName = "id")
			)
	private Set<Director> directores;
	
	@OneToMany(mappedBy = "pelicula")
	@JsonIgnore
	private List<Ejemplar> ejemplares;
	
}
