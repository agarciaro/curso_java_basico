package com.sopra.videoclub.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alquiler {

	@EmbeddedId
	private AlquilerKey id;

	@ManyToOne
	@MapsId("idEjemplar")
	@JoinColumn(name = "id_ejemplar")
	private Ejemplar ejemplar;

	@ManyToOne
	@MapsId("idSocio")
	@JoinColumn(name = "id_socio")
	private Socio socio;
	
	
	@Column(nullable= false)
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucion;

}