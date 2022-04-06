package com.sopra.equipoa.videoclub.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.sopra.equipoa.videoclub.model.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroDto {
	
	@NotEmpty
	private String codigoInvitacion;
	private Long idSocioReferido;
	@NotNull
	private Usuario usuario;
}
