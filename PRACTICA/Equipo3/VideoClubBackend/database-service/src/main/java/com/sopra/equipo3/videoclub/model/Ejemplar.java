package com.sopra.equipo3.videoclub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ejemplar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroEjemplar;
	private boolean estadoCon;
	
}
