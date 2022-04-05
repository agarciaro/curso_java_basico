package com.sopra.equipo4.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Socio {
	
	@Id
	private String dni;
	private String direccion;
	private Long telefono;
	private String nombre;
	
	@OneToMany(mappedBy = "socio")
	private Set<Ejemplar> ejemplaresAlquilados;
	
	@OneToMany(mappedBy = "avalanteDe")
	private Set<Socio> avaladoPor;
	@ManyToOne
	@JoinColumn(name = "avalante_de", referencedColumnName = "dni")
	private Socio avalanteDe;
	
}
