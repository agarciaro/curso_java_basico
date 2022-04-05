package com.sopra.videoclub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Actor {

	@Id
	private String nombre;
	private String nacionalidad;
	private String sexo;
	
	@Column(columnDefinition = "VARCHAR(60) CHECK (rol IN ('PRINCIPAL', 'SECUNDARIO'))")
	private String rol;
	
	
	
	
}
