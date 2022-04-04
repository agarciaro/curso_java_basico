package com.sopra.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariCredencials {
	private String username;
	private String password;
}
