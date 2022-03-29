package com.sopra.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exemplar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numExemplar;
	private Integer anyEdicio;
	private Integer numEdicio;
	
//	@Exclude
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name="codi_llibre", nullable = false)
	private Llibre llibre;

}
