package com.sopra.prueba;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * 
 * @author kiskuz
 *
 * @version 2.0
 * @since 2020
 * 
 */
public class HolaMundo {
	
//	@Deprecated
	public static void main(String... args) throws Exception {
		System.out.println("Adiós " + args[0] + "!");
		
		//Imprimir número aleatorio
//		Random r = new Random();
		System.out.println(new Random().nextInt(10));
		
		Date ahora = new Date();
		java.sql.Date ahorita = new java.sql.Date(0);
		
		HolaMundo h = new HolaMundo(3);
		HolaMundo p = new HolaMundo();
		
		Chicken pollo = new Chicken();
		pollo = null;
		System.gc();
		pollo = new Chicken();
		pollo.name = "Jose";
		
		int a = (int)1.3;
		System.out.println(a);
		short y = (short)1921222;
		y = Short.MAX_VALUE;
		System.out.println("Y:" + y);
		
		short x = 10;
		short w = 3;
		short z = (short)(x * w);
		
		System.out.println(pollo instanceof Chicken);
		
		String str = null;
		System.out.println(str instanceof String);
		
		List<Chicken> pollos = new ArrayList<>();
		pollos.add(new Chicken());
		for (Chicken chicken : pollos) {
			System.out.println(chicken);
		}
		
		System.out.printf("Esto es un string %s, esto es un entero %d, esto es un float %f\n", "hola", 2, 4.3);
		
		Listas l = new Listas();
		
//		l.setImmutableVar(7);
		
		System.out.println(l.getImmutableVar());
		
		Calendario c = Calendario.getInstance();
		
		Constructores cons = new Constructores();
		System.out.println(cons.getPalabra());
		
	}
	
	public HolaMundo() {
		System.out.println("En el constructor sin parámetros");
	}
	
	public HolaMundo(Integer num) {
		this();
	}
	
	public static void metodo() throws Exception {
		main(null);
	}
	
	

}

//class Prueba{
//	
//}
