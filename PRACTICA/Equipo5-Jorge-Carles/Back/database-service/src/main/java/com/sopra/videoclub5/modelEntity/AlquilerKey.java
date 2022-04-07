package com.sopra.videoclub5.modelEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlquilerKey implements Serializable {

	@Column(name = "num_socio")
	private Integer numSocio;

	@Column(name = "num_ejemplar")
	private Integer numEjemplar;
}
