package com.sopra.equipo4.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ActorPelicula {
	
	@EmbeddedId
	ActorPeliculaPK id;
	
	@ManyToOne
	@MapsId("actorId")
	@JoinColumn(referencedColumnName = "id")
	private Actor actor;
	
	@ManyToOne
	@MapsId("peliculaId")
	@JoinColumn(referencedColumnName = "id")
	private Pelicula pelicula;
	
	private String papel;
}
