package com.sopra.prueba;

import java.util.ArrayList;
import java.util.List;

public class Estaticos {

//	public static int count = 0;

	
	static {
		int numSecondsPerMinute = 60;
		int numMinutesPerHour = 60;
		NUM_SECONDS_PER_HOUR = numSecondsPerMinute * numMinutesPerHour;
	}
	private static final int NUM_SECONDS_PER_HOUR;
	
	private final List<String> LISTA;
	
	{
		LISTA = new ArrayList<>();
		LISTA.add("1");
		LISTA.add("2");
	}

	public static void main(String[] args) {
//		Estaticos e1 = new Estaticos();
//		Estaticos e2 = new Estaticos();
//		
//		Estaticos.count = 3;
//		
//		System.out.println(count);
//		System.out.println(e2.count);

//		Estaticos.main(new String[0]);
	}

}
