package com.sopra.videoclub5.modelEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaActorKey implements Serializable {

	@Column(name = "id_pelicula")
	private Integer idPelicula;

	@Column(name = "id_actor")
	private Integer idActor;

}
