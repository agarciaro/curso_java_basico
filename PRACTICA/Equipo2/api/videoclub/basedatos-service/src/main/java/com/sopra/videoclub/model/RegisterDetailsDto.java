package com.sopra.videoclub.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDetailsDto {
	
	@NotEmpty
	private String codInvitacion;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	private Integer codReferencia;

}
