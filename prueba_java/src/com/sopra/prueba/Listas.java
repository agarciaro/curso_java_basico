package com.sopra.prueba;

public class Listas {
	
	private Integer immutableVar = 3; 
	
	public static void main(String[] args) {
		final int[] numbers = {6, 9, 1};
		numbers[0] = 4;
		
		for (int i : numbers) {
			System.out.println(i);
		}

	}

	public Integer getImmutableVar() {
		return immutableVar;
	}
	
	public void setImmutableVar(Integer i) throws Exception {
		throw new Exception("No se puede modificar la variable");
	}

}
