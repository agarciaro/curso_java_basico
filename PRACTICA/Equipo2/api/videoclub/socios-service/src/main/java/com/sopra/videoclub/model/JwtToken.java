package com.sopra.videoclub.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtToken implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String token;
	private String username;
}
