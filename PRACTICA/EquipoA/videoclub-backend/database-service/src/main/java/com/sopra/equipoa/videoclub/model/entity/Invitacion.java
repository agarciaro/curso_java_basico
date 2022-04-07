package com.sopra.equipoa.videoclub.model.entity;

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
public class Invitacion{

	@Id
	@Column(name = "id_socio")
	private Long idSocio;
	
	@OneToOne
	@MapsId("idSocio")
	@JoinColumn(referencedColumnName = "id", name = "id_socio")
	private Socio socio;
	
	@Column(nullable = false)
	private String codigo;
}
