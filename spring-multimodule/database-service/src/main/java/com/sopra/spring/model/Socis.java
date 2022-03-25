package com.sopra.spring.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Socis {
	@Id
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
