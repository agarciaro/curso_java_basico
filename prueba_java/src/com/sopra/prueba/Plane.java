package com.sopra.prueba;

public class Plane {

//	public void fly(long l) {
//	System.out.println("long");
//}
	public void fly(int l) {
		System.out.println("int");
	}
	
	public void fly(int i1, int i2) {
		System.out.println("int");
	}
	
	public void fly(float f1, float f2) {
		System.out.println("float");
	}
	
	public static void main(String[] args) {
		Plane p = new Plane();
//		p.fly(123);
//		p.fly((int)123L);
		p.fly(1, 2L);//float
		p.fly(1L, 2);//float
	}

//	public static void play(Long l) {
//	}
//
//	public static void play(Long... l) {
//	}
//
//	public static void main(String[] args) {
//		play(4); // DOES NOT COMPILE
//		play(4L); // calls the Long version
//	}

}
