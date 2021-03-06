package com.sopra.videoclub5.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtToken implements Serializable {
	private static final long serialVersionUID = 5615608530797516602L;

	private String token;

	private List<String> roles;

}
