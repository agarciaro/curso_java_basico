package com.sopra.spring;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sopra.spring.annotation.PruebasService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringAopApplication {
	
	@Autowired
	PruebasService pruebasService;
	
	@Value("${mi_clave:defecto}")
	String valor;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		
		log.info("VALOR:{}", valor);
		
		pruebasService.funcion1();
		pruebasService.funcion2();
		pruebasService.funcion3();
		
		Method[] metodos = PruebasService.class.getDeclaredMethods();
		for (Method method : metodos) {
			log.info("Metodo:{}", method);
			Annotation[] annotations = method.getAnnotations();
			for (Annotation annotation : annotations) {
				log.info(" Annotation:{}", annotation);
			}
		}
		
	}

}
