package com.sopra.equipoa.videoclub.model.entity;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nombre;
	private String nacionalidad;
	
	@Exclude
	@ManyToMany(mappedBy = "directores")
	private Set<Pelicula> peliculas;

}
