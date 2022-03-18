package com.sopra.prueba;

public class PatronBuilder {

	private String nombre;
	private String apellidos;
	private Integer edad;
	
	public static void main(String[] args) {
		
		PatronBuilder patron = new PatronBuilder()
								.setNombre("Pepe")
								.setApellidos("Gómez")
								.setEdad(30);
		
	}
	
	public PatronBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public PatronBuilder setApellidos(String apellidos) {
		this.apellidos = apellidos;
		return this;
	}
	
	public PatronBuilder setEdad(Integer edad) {
		this.edad = edad;
		return this;
	}

}
