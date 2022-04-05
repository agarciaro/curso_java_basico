package com.sopra.equipo4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String nacionalidad;
	private String sexo;
	
//	@ManyToMany(mappedBy = "actores")
//	private Set<Pelicula> actuadoEn;
	
//	private String rol;
	
}
