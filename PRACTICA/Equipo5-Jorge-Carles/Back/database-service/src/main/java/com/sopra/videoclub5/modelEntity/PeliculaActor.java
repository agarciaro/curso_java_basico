package com.sopra.videoclub5.modelEntity;

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
    PeliculaActorKey id;

    @ManyToOne
    @MapsId("idPelicula")
    @JoinColumn(name = "id_pelicula")
    Pelicula pelicula;

    @ManyToOne
    @MapsId("idActor")
    @JoinColumn(name = "id_actor")
    Actor actor;

	@Column(columnDefinition = "VARCHAR (60) CHECK (papel IN ('principal','secundario'))")
	private String papel;

}
