package com.sopra.equipo4.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	@Id
	private String username;
	private String password;
	
	@ManyToMany
	@JoinTable(
		name = "usuario_rol",
		joinColumns = @JoinColumn(name = "rol_id"),
		inverseJoinColumns = @JoinColumn(name = "usuario_id")
	)
	private Set<Rol> roles;
	
	@OneToOne
	@JoinColumn(name = "socio_id", updatable = false, nullable = true)
	private Socio socio;
}
