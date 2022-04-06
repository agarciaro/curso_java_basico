package com.sopra.equipo4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ejemplar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numEjemplar;
	
	private String estado;
//	@OneToMany(mappedBy = "ejemplar")
//	private Set<Socio> alquiladaPor;
	
	@ManyToOne
	@JoinColumn(name = "pelicula_id", nullable = false)
	private Pelicula pelicula;
}
