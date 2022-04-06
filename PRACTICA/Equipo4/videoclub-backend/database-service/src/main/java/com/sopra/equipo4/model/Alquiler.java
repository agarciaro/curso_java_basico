package com.sopra.equipo4.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alquiler {
	
	@EmbeddedId
	AlquilerPK id;
	
	@ManyToOne
	@MapsId("socioId")
	@JoinColumn(referencedColumnName = "id")
	private Socio socio;

	@ManyToOne
	@MapsId("numEjemplar")
	@JoinColumn(name = "num_ejemplar", referencedColumnName = "numEjemplar")
	private Ejemplar ejemplar;
	
	@Column(name = "fecha_devolucion")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fechaDevolucion;
	
}
