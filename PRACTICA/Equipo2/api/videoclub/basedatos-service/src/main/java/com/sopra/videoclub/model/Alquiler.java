package com.sopra.videoclub.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alquiler {
	@EmbeddedId
	private AlquilerPK id;
	
	
	
	private LocalDate fechaDevolucion;
	
	@ManyToOne
	@MapsId("ejemplarId")
	@JoinColumn(name = "num_ejemplar")
	private Ejemplar ejemplar;
	
	@ManyToOne
	@MapsId("socioId")
	@JoinColumn(name = "num_socio")
	private Socio socio;

}
