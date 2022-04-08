package com.sopra.equipo3.videoclub.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ActorPelicula {
	@EmbeddedId
	private ActorPeliculaPK id;

	@ManyToOne
	@MapsId("idActor")
	@JoinColumn(name = "id_actor")
	private Actor actor;

	@ManyToOne
	@MapsId("idPelicula")
	@JoinColumn(name = "id_pelicula")
	private Pelicula pelicula;
	
	@Column(columnDefinition = "VARCHAR(60) CHECK (papel IN ('PRINCIPAL', 'SECUNDARIO', 'Principal', 'Secundario', 'principal', 'secundario'))")
	private String papel;
	
	
	
}
