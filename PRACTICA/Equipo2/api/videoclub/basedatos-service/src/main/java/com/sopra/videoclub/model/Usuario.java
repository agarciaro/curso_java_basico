package com.sopra.videoclub.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

	@Id
	@Column(updatable = false, nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "usuario_rol",
				joinColumns = @JoinColumn(name="usuario",referencedColumnName = "username"),
				inverseJoinColumns = @JoinColumn(name="rol_nombre",referencedColumnName = "nombre")
			)
	private Set<Rol> roles = new HashSet<>();
	
	@OneToOne(mappedBy = "usuario")
	@JsonIgnore
	private Socio socio;

}
