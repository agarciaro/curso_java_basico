package com.sopra.equipo4.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alquiler_ejemplar")
@IdClass(AlquilerId.class)
public class Alquiler {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "socio_dni", referencedColumnName = "dni")
	private Socio socio;
	@Id
	@ManyToOne
	@JoinColumn(name = "ejemplar_id", referencedColumnName = "numEjemplar")
	private Ejemplar ejemplar;
	
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;
	@Column(name = "fecha_devolucion")
	private LocalDate fechaDevolucion;
	
}
