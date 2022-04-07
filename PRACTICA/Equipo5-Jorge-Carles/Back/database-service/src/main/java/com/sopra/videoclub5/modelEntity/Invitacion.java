package com.sopra.videoclub5.modelEntity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invitacion {

	@EmbeddedId
	InvitacionKey id_socio;

	@ManyToOne
	@MapsId("idPelicula")
	@JoinColumn(name = "num_socio")
	Socio socio;

	@Column(nullable = false)
	private Integer codigo;

}
