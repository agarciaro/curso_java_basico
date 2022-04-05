package com.sopra.equipo3.videoclub.model;

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
public class ActorPeliculaPK implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_actor")
	private Long idActor;
	@Column(name = "id_pelicula")
	private Long idPelicula;
}
