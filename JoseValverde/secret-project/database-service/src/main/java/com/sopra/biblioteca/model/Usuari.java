package com.sopra.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
	
}
