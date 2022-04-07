package com.sopra.equipo4.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtToken implements Serializable {
	
	private static final long serialVersionUID = 7948132383291610033L;
	
	private String token;
	private String username;
	private List<String> roles;
}
