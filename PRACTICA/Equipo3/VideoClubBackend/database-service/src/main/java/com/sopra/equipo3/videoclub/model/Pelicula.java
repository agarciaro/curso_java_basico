package com.sopra.equipo3.videoclub.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String nacionalidad;
	private String productora;
	private LocalDate fecha;
	private String url;
	
	@ManyToMany
	@JoinTable(
			name = "pelicula_director", 
			joinColumns = @JoinColumn(name = "id_pelicula", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "id_director", referencedColumnName = "id")
			)
	private Set<Director> directores;


}