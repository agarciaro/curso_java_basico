package com.sopra.videoclub.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {

	@Id
	private String titulo;
	private String nacionalidad;
	private String productora;
	private LocalDate fecha;
	
}
