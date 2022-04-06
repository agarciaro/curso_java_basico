package com.sopra.equipo3.videoclub.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AlquilerPK implements Serializable{


	private static final long serialVersionUID = 8887869270479460615L;
	
	@Column(name = "id_socio")
	private Long idSocio;
	@Column(name = "id_ejemplar")
	private Long idEjemplar;
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;

}
