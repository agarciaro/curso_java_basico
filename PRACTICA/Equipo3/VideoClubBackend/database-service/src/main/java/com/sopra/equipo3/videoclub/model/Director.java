package com.sopra.equipo3.videoclub.model;

import java.util.Set;

import javax.persistence.Column;
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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nombre;
	private String nacionalidad;
	
	
	@ManyToMany
	@JoinTable(name = "pelicula_director", joinColumns = @JoinColumn(name = "id_director", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_pelicula", referencedColumnName = "id"))
	private Set<Pelicula> peliculas;

}
