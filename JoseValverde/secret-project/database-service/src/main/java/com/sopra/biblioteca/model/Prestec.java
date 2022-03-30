package com.sopra.biblioteca.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"codi_soci", "num_exemplar", "data_prestec"})})
public class Prestec {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codiPrestec;
	
	@ManyToOne
	@JoinColumn(name = "codi_soci", referencedColumnName = "codi", nullable = false)
	private Soci soci;
	
	@ManyToOne
	@JoinColumn(name = "num_exemplar", nullable = false)
	private Exemplar exemplar;
	
	@Column(nullable = false, name = "data_prestec")
//	@Temporal(TemporalType.DATE)
	private LocalDate dataPrestec;
	
	private LocalDate dataLimit;
	private LocalDate dataDevolucio;
	
}
