package com.sopra.equipo4.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

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
	@JoinColumn(referencedColumnName = "numEjemplar")
	private Ejemplar ejemplar;
	
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;
	@Column(name = "fecha_devolucion")
	private LocalDate fechaDevolucion;
	
}
