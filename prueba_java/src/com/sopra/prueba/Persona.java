package com.sopra.prueba;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	
//	public String getTrigrama() {
//		StringBuilder sb = new StringBuilder(3);
//		sb.append(this.nombre.charAt(0))
//		.append(this.apellido1.charAt(0))
//		.append(this.apellido2 != null?this.apellido2.charAt(this.apellido2.length()-1):"");
//		return sb.toString();
//	}	
	
}
