package com.sopra.videoclub5.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

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
	
	@Column(name= "fecha_inicio",nullable = false)
	private LocalDate fechaInicio;
	//,insertable = false, updatable = false, columnDefinition = "DATE DEFAULT current_date()"

	@Column(nullable = true)
	private LocalDate fechaDevolucion;

	@ManyToOne
	@MapsId("numSocio")
	@JoinColumn(name = "num_socio")
	Socio socio;

	@ManyToOne
	@MapsId("numEjemplar")
	@JoinColumn(name = "num_ejemplar")
	Ejemplar ejemplar;
}
