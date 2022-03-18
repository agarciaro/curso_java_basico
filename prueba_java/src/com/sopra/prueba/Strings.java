package com.sopra.prueba;

public class Strings {

	public static void main(String[] args) {
		String name = "Pepe";
		String name2 = new String("Pepe");
		
		String doce = "1" + "2";
		
		System.out.println("a" + "b" + 3);
		System.out.println(1 + 2 + "c");
		
		String s = "1"; // "1"
		s += "2"; // "12"
		s += 3; // "123"
		
		String s2 = "123";
		
		System.out.println(s);
		
		System.out.println("Abc123".toUpperCase());
		
		StringBuilder sb = new StringBuilder(5);
		sb.append("anim");
		
		System.out.println(sb.length());

	}

}
