package com.sopra.videoclub.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	private Integer numSocio;
	private String nombre;
	private String direccion;
	private String telefono;
	
//	
//	@OneToMany(targetEntity = Socio.class, mappedBy = "numSocio", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	private Set<Socio> socios;
	
}
