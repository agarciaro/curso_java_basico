package com.sopra.prueba;

public class Bucles {
	public static void main(String[] args) {
		
		int[][] arrayBidimensional = {{5, 2, 1, 4}, {3, 9, 8, 4}, {2, 7, 5, 8}};
		String salida = "";
		for (int[] arrayUnidimensional : arrayBidimensional) {
			for (int i = 0; i < arrayUnidimensional.length; i++) {
				salida += arrayUnidimensional[i]+"\t";
				System.out.print(salida);
				continue;
			}
			System.out.println();
		}

	}
}
