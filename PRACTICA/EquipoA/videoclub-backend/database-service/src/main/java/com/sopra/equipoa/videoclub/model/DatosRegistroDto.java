package com.sopra.equipoa.videoclub.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosRegistroDto {
	
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String codigoInvitacion;
	private Long idSocioReferido;
}
