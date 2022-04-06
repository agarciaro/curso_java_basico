package com.sopra.equipo4.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AlquilerPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "num_ejemplar")
	private Integer numEjemplar;
	@Column(name = "socio_id")
	private Integer socioId;
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;
}
