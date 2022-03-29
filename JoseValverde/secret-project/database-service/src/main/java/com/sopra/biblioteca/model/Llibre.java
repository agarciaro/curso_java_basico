package com.sopra.biblioteca.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Llibre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codi;
	private String titol;
	private String editorial;
	private String idioma;
	private String autor;
	private Integer numEds;
	
	@Exclude
	@ManyToOne
	@JoinColumn(name = "codi_tema", nullable = false) // Al ser una relación se utiliza JoinColumn
	private Tema tema;
	
	@Exclude
	@OneToMany(mappedBy = "llibre", fetch = FetchType.LAZY  )
	private Set<Exemplar> exemplars; 
	

}
