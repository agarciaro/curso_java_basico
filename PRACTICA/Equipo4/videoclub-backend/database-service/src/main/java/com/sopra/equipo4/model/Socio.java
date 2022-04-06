package com.sopra.equipo4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Socio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String dni;
	private String direccion;
	private String telefono;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "avalado_por", referencedColumnName = "id")
	private Socio avaladoPor;
	
	@OneToOne(mappedBy = "socio")
	private Usuario usuario;
}
