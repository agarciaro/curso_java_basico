package com.sopra.tests;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.sopra.tests.exception.DivisionPorCeroException;

public class CalculatorTest {
	
	Calculator calculator;
	boolean bool;
	
	@BeforeAll
	public static void initTestClass() {
		System.out.println("En @BeforeAll");
	}
	
	@BeforeEach
	public void initTests() {
		System.out.println("En @BeforeEach");
		calculator = new Calculator();
		bool = false;
	}
	
	@AfterAll
	public static void finishTestClass() {
		System.out.println("En @AfterAll");
	}
	
	@AfterEach
	public void finishTests() {
		System.out.println("En @AfterEach");
	}
	
	@Test
	@Tag("a")
	public void additionOf2PossitiveFloatsShouldReturnSum() {
		assertEquals(2, calculator.add(1, 1));
	}
	
	@Test
	@Tag("a")
	public void additionOf2NegativeFloatsShouldReturnSum() {
		assertEquals(-5, calculator.add(-3, -2), "La suma no es correcta");
	}
	
	@Test
//	@Disabled
	@Tag("b")
	public void calculatorIsNotNull() {
		assertNotNull(calculator, "El objeto Calculator no está inicializado");
	}
	
	@Test
//	@Disabled
	@DisplayName("Varios tests con lambdas")
	public void additionTestsWithLambdas() {
		assertAll(
				() -> assertEquals(2, calculator.add(1, 1)),
				() -> assertEquals(-5, calculator.add(-3, -2), "La suma no es correcta"),
				() -> assertNotNull(calculator, "El objeto Calculator no está inicializado")
		);
		
//		assertEquals(10, calculator.add(10, 1), () -> "Fallo debido a que los números no se suman correctamente");
	}
	
	@DisplayName("Repeated Test")
	@RepeatedTest(value = 5, name = "{displayName} -> {currentRepetition} of {totalRepetitions}")
	public void erpeticiondeTest(RepetitionInfo repetitionInfo) {
		int arbitrary = 2;
		System.out.println("Current iteration: " + repetitionInfo.getCurrentRepetition());
		
		assertEquals(arbitrary, repetitionInfo.getCurrentRepetition());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {6, 2, 8, 9})
	public void shouldBeLessThan10(int number) {
		assertTrue(number < 10, "Number isn´t less than 10");
	}
	
	@Test
	public void asunciones() {
		assumeTrue(bool, "Stop executing test due to variable bool isn´t true");
		System.out.println("Ejecutando método");
	}
	
	@Test
	void divisionTests() throws DivisionPorCeroException {
		assertEquals(2, calculator.divide(5, 2), "5/2 no redondea a la baja");
		
		assertThrows(DivisionPorCeroException.class, () -> calculator.divide(2, 0));
	}
	
}
