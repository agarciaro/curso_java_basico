package com.sopra.equipo4.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String nacionalidad;
	private String productora;
	private LocalDate fecha;

	@OneToMany(mappedBy = "pelicula")
	private Set<Ejemplar> ejemplares;

	@ManyToMany
	@JoinTable(name = "pelicula_director", 
		joinColumns = @JoinColumn(name = "pelicula_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "director_id", referencedColumnName = "id")
	)
	private Set<Director> directores;
	
//	@ManyToMany
//	@JoinTable(name = "pelicula_actor",
//		joinColumns = @JoinColumn(name = "pelicula_id", referencedColumnName = "id"),
//		inverseJoinColumns = @JoinColumn(name="actor_id", referencedColumnName = "id")
//	)
//	private Set<Actor> actores;

}
