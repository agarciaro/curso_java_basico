package com.sopra.biblioteca;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Socis {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer codi;
	
	private String nom;
	private String cognom;
	private String dni;
	private String adreca;
	private String codiPostal;
	private String ciutat;
	private String provincia;
	private String telefon;
	private LocalDate dataAlta;
	
}