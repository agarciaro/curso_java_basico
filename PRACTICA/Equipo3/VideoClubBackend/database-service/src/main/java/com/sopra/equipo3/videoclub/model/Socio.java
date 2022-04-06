package com.sopra.equipo3.videoclub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Socio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String dni;
	@Column(nullable = false)
	private String nombre;
	private String telefono;
	private String direccion;

	@OneToOne
	@JoinColumn(name="avalado_por", referencedColumnName = "id")
	private Socio avaladoPor;
}
