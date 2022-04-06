package com.sopra.videoclub.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String titulo;
	private String nacionalidad;
	private String productora;
	private Date fecha;
	@ManyToMany
	@JoinTable(name="pelicula_director",
				joinColumns = @JoinColumn(name="id_pelicula", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name="id_director", referencedColumnName = "id"))
	private Set<Director> directores;
	
	
	
	

}