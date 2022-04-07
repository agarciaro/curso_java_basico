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
public class SocioUsuario {
	
	@Id
	@Column
	private Integer idSocio;
	
	@OneToOne
	@MapsId("idSocio")
	@JoinColumn(name = "id_socio")
	private Socio socio;
	
	@OneToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
}
