package com.sopra.equipo4.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ActorPeliculaPK implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "actor_id")
	private Integer actorId;
	@Column(name = "pelicula_id")
	private Integer peliculaId;
}
