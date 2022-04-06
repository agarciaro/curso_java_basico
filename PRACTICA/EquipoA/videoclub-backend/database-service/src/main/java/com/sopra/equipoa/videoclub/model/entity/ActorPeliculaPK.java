package com.sopra.equipoa.videoclub.model.entity;

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

	private static final long serialVersionUID = -4137944487060311080L;
	
	@Column(name = "id_actor")
	private Long idActor;
	@Column(name = "id_pelicula")
	private Long idPelicula;
}
