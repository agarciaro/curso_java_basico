package com.sopra.equipo4.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "asignacion_codigo_socio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignacionSocio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7812898579754302450L;
	@Id
	@OneToOne
	@JoinColumn(name = "socio_id", updatable = false, nullable = false)
	private Socio socio;
	private String codigo;
}
