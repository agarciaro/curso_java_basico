package com.sopra.biblioteca.model;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuari {
	
	@Id
	@Column(updatable = false, nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "usuari_rol", 
			joinColumns = @JoinColumn(referencedColumnName = "username"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "nom")
	)
	private Set<Rol> roles = new HashSet<>();
	
}
