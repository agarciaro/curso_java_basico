package com.sopra.equipo3.videoclub.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtToken implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 396620001468213500L;

	private String token;
	
	private String username;
	
	private List<String> roles;
	
}
