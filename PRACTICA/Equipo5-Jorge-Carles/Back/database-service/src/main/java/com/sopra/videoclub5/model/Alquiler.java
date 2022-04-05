package com.sopra.videoclub5.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Tabla intermedia entre Ejemplar y Socio
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alquiler {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Date fechaInicio;

	@Column(nullable = true)
	private Date fechaDevolucion;

	@ManyToOne
	@JoinColumn(name = "num_socio", nullable = false)
	private Socio socio;

	@ManyToOne
	@JoinColumn(name = "num_ejemplar", nullable = false)
	private Ejemplar ejemplar;

}
