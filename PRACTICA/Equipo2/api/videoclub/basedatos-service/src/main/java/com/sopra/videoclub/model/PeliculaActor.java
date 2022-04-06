package com.sopra.videoclub.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaActor {

	
	@EmbeddedId
	private PeliculaActorPK id;
	
	@ManyToOne
	@MapsId("actorId")
	@JoinColumn(name = "actor_id")
	private Actor actor;
	
	@ManyToOne
	@MapsId("peliculaId")
	@JoinColumn(name = "pelicula_id")
	private Pelicula pelicula;
	
	@Column(columnDefinition = "VARCHAR(60) CHECK( rol IN ('PRINCIPAL', 'SECUNDARIO'))")
	private String rol;
}
