package com.sopra.tests;

import com.sopra.tests.exception.DivisionPorCeroException;

public class Calculator {
	
	public float add(float a, float b) {
		return a+b;
	}
	
	public int divide(int a, int b) throws DivisionPorCeroException{
		if(b == 0) {
			throw new DivisionPorCeroException();
		}
		return a/b;
	}

}
