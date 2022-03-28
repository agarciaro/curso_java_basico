package com.sopra.biblioteca.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Soci {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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