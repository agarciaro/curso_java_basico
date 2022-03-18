package com.sopra.prueba;

public class Calendario {

	private static Calendario instance;
	
	private Calendario() {
		
	}
	
	public static Calendario getInstance() {
		if(instance == null) {
			instance = new Calendario();
		}
		return instance;
	}
}
