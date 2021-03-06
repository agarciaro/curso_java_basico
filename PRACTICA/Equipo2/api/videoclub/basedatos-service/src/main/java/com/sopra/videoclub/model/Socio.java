package com.sopra.videoclub.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@ManyToOne
	@JoinColumn(name = "avalado_por")
	@JsonManagedReference
	private Socio avaladoPor;
	
	@OneToMany(mappedBy = "socio")
	@JsonManagedReference
	private Set<Alquiler> ejemplares;
	
	@OneToOne(mappedBy = "socio")
	@JsonManagedReference
	private CodigoInvitacion codigoInvitacion;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "socio_usuario",
			joinColumns =
					@JoinColumn(name = "num_socio"),
			inverseJoinColumns =
					@JoinColumn(name = "username")
			)
	private Usuario usuario;
}
