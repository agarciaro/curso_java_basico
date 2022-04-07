package com.sopra.videoclub5.modelEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
	
	@Id
	private Integer id;
	
	private String descripcion;
	
	@Column(nullable = false)
	private String nombre;
	
	@ManyToMany (mappedBy = "roles")
	Set<Usuario> usuarios;

}
