package com.sopra.prueba;

public class Chicken {
	int numEggs = 0;
	int max = Integer.MAX_VALUE;
	long maxLong = 3123456789L;
	
	int millon1 = 1000000;
	int millon2 = 1_000_000;
	double alPrincipio = 1_000.0_0;
	String saludo = "Hola".concat(" Pepe");
	
	String name = "Pepe";
	
	String s1, s2;
	String s3 = "yes", s4 = "no";
	int i1, i2, i3 = 9;
	
//	int number; String value;
	
	{
		name = "Mariano";
	}
	
	public Chicken() {
		this.name = "Paco";
	}
	
	public Chicken(String nombre) {
		this.name = nombre;
	}
	
	@Override
	protected void finalize() {
		System.out.println("Finalize");
	}
}
