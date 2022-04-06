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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ActorPelicula {
	@EmbeddedId
	private ActorPeliculaKey id;

	@ManyToOne
	@MapsId("idActor")
	@JoinColumn(name = "id_actor")
	private Actor actor;

	@ManyToOne
	@MapsId("idPelicula")
	@JoinColumn(name = "id_pelicula")
	private Pelicula pelicula;
	
	@Column(columnDefinition = "varchar(60) check (papel in ('PRINCIPAL', 'SECUNDARIO'))")
	private String papel;

}
