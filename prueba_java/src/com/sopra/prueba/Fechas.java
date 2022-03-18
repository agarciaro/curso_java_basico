package com.sopra.prueba;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Fechas {

	public static void main(String[] args) {
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());
		
		LocalDate date1 = LocalDate.of(2022, 3, 16);
		LocalDate date2 = LocalDate.of(2022, Month.MARCH, 16);
		
		LocalDateTime dateTime1 = LocalDateTime.now();
		
		LocalTime time1 = LocalTime.of(9, 28, 30);
		
//		LocalDate date3 = new LocalDate();
//		LocalDate date3 = LocalDate.of(2022, 15, 12);
		
		
		date1 = date1.plusDays(1).minusMonths(2);
		
//		date2 = date2.plusMinutes(); NO COMPILA
		
		Period anual = Period.ofYears(1);
		Period cadaAnyoYSemana = Period.of(1, 0, 7);
		
		System.out.println(date2.plus(cadaAnyoYSemana));
		
		System.out.println(date2.format(DateTimeFormatter.ISO_DATE));
		System.out.println(dateTime1.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
		System.out.println(dateTime1.format(f));
		
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("MM dd yyyy");
		System.out.println(dateTime1.format(f2));
		
	}

}
