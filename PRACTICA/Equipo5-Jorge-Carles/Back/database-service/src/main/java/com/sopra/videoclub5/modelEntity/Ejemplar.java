package com.sopra.videoclub5.modelEntity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ejemplar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer numEjemplar;
	private String estado;
	
	@OneToMany(mappedBy = "ejemplar")
    Set<Alquiler> AlquiladoPor;
	
	@ManyToOne
	@JoinColumn(name = "id_pelicula", nullable = false)
	private Pelicula pelicula;

}
