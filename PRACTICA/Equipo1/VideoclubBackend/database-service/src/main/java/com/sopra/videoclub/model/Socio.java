package com.sopra.videoclub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Integer id;
	@Column(nullable=false, unique = true)
	private String dni;
	@Column(nullable=false)
	private String nombre;
	private String direccion;
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name = "avalado_por", referencedColumnName = "id")
	private Socio avaladoPor;
	
	
	

	

}
