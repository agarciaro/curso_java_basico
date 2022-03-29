package com.sopra.spring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class JugadorAleatorio {

	public static void main(String[] args) throws InterruptedException {
		List<String> nombres = new ArrayList<>();
		nombres.add("Alberto");
		nombres.add("Sergio");
		nombres.add("Francesc");
		nombres.add("Jorge");
		nombres.add("Valentin");
		nombres.add("Jose");
		nombres.add("Cristian");
		nombres.add("Miguel");
		nombres.add("Carles");
		nombres.add("Juan Carlos");
		nombres.add("Noah");
		
		Random r = new Random();
		System.out.println("**** THE WINNER IS..... ****");
		Thread.sleep(2500);
		System.out.println(nombres.get(r.nextInt(nombres.size())));
		
		

	}

}
