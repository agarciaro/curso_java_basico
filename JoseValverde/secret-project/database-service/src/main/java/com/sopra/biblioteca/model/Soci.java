package com.sopra.biblioteca.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.sopra.biblioteca.annotation.TamanyMaxim;

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
//	@Column(nullable = false)
	@NotNull
	@TamanyMaxim(tamany = 50, message = "Nom ha de ser menor de 50")
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