package com.sopra.equipo4.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
	@Id
	private String nombre;
	private String descripcion;
	@ManyToMany(mappedBy = "roles")
	Set<Usuario> usuarios;
}
