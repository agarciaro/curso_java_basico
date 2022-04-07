package com.sopra.videoclub5.modelEntity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Socio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numSocio;

	@Column(nullable = false, unique = true)
	private String dni;

	@Column(nullable = false)
	private String nombre;
	private String direccion;
	private String telefono;

	@OneToMany(mappedBy = "socio")
	Set<Alquiler> ejemplarAlquilado;

	@ManyToOne
	@JoinColumn(name = "avalado_por", nullable = true)
	private Socio avaladoPor;

	@OneToOne
	@JoinTable(name = "socio_usuario", 
		joinColumns = @JoinColumn(name = "num_socio", referencedColumnName = "numSocio"), 
		inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"))

	private Usuario Usuario;

}
