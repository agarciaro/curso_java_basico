package com.sopra.videoclub.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
public class Alquiler {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private LocalDate fecInicio;
	private LocalDate fecDev;
	
	@ManyToOne
	@JoinColumn(name = "num_ejemplar")
	private Ejemplar ejemplar;
	
	@ManyToOne
	@JoinColumn(name = "num_socio")
	private Socio socio;

}
