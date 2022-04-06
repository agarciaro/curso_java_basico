package com.sopra.equipo3.videoclub.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AlquilerPK implements Serializable {

	private static final long serialVersionUID = 4496720059051927881L;

	@Column(name = "id_socio")
	private Long idSocio;
	@Column(name = "id_ejemplar")
	private Long idEjemplar;

}
