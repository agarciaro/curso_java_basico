package com.sopra.videoclub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodigoInvitacion {

	@Id
	@Column(name = "socio_id")
	private Integer socioId;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "socio_id")
	private Socio socio;
	private String codigo;
}
