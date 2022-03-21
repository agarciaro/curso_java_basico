package com.sopra.spring.prueba.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona {
	
	@Id
	private Integer id;
	private String nombre;
	private Integer edad;
}
