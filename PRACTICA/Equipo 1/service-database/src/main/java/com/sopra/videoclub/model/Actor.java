package com.sopra.videoclub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codi;
//	@Column(nullable = false)
	@NotNull

	private String nombre;
	private String nacionalidad;
	private String sexo;

}