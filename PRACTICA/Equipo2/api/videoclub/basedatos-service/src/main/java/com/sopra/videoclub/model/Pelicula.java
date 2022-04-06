package com.sopra.videoclub.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Actor> actores;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "pelicula_director",
			joinColumns = @JoinColumn(name ="director_id", referencedColumnName = "id"),
			inverseJoinColumns =  @JoinColumn(name ="pelicula_id", referencedColumnName = "id")
			)
	private List<Director> directores;
	
	@OneToMany(mappedBy = "pelicula")
	private List<Ejemplar> ejemplares;
	
}
