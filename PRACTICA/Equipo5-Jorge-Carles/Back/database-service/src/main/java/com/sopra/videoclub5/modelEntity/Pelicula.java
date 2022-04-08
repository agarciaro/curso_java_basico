package com.sopra.videoclub5.modelEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String titulo;

	private String nacionalidad;
	private String productora;
	private LocalDate fecha;
	@Column(name = "url_video")
	private String urlVideo;
	@Column(name = "url_poster")
	private String urlPoster;
	@Column(name = "url_fondo")
	private String urlFondo;
	@Lob
	private String sinopsis;

	@ManyToMany 
	@JoinTable (
		name = "pelicula_director",
		joinColumns = @JoinColumn(name="id_director", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "id_pelicula", referencedColumnName = "id")
	)
	private Set<Director> directores;
	

	
	@OneToMany(mappedBy = "pelicula")
    Set<PeliculaActor> actores;
	
	
	
	
}
