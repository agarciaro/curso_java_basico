package com.sopra.equipo4.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AsignacionSocio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7812898579754302450L;
	@Id
	private Integer socioId;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "socio_id", updatable = false, nullable = false)
	private Socio socio;
	private String codigo;
	
	
	public AsignacionSocio(Socio socio, String codigo) {
		this.socio = socio;
		this.codigo = codigo;
	}
}
