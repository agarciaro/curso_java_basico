package com.sopra.videoclub.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlquilerPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="fecha_inicio")
	private LocalDate fechaInicio;
	@Column(name="ejemplar_id")
	private Integer ejemplarId;
	@Column(name="socio_id")
	private Integer socioId;
	
}
