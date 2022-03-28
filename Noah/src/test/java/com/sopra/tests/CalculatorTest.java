package com.sopra.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	public void additionOf2PossitiveFloatsShouldReturnSum() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1));
	}
	
	@Test
	public void additionOf2NegativeFloatsShouldReturnSum() {
		Calculator calculator = new Calculator();
		assertEquals(-5, calculator.add(-3, -2), "La suma no es correcta");
	}
	
}
