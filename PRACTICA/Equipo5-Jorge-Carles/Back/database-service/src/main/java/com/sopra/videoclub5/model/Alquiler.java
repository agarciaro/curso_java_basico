package com.sopra.videoclub5.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Tabla intermedia entre Ejemplar y Socio
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alquiler implements Serializable {

	@EmbeddedId
	AlquilerKey id;
	
	@Column(nullable = false)
	private Date fechaInicio;

	@Column(nullable = true)
	private Date fechaDevolucion;

	@ManyToOne
	@MapsId("numSocio")
	@JoinColumn(name = "num_socio")
	Socio socio;

	@ManyToOne
	@MapsId("numEjemplar")
	@JoinColumn(name = "num_ejemplar")
	Ejemplar ejemplar;
}
