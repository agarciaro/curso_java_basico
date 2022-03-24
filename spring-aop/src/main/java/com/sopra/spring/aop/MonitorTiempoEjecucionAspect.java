package com.sopra.spring.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.sopra.spring.annotation.LogueaTiempo;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class MonitorTiempoEjecucionAspect {
	
	@Around("@annotation(com.sopra.spring.annotation.LogueaTiempo)")
	public void logueaTiempoEjecucionMetodo(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature =(MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		LogueaTiempo annotation = method.getAnnotation(LogueaTiempo.class);
		
		long tiempoInicial = System.currentTimeMillis();
		joinPoint.proceed();
		long tiempoEjecucion = System.currentTimeMillis() - tiempoInicial;
		
		if(tiempoEjecucion > annotation.maxTiempo()) {
			log.error("Tiempo de ejecución excedido! (max={}, actual={})", annotation.maxTiempo(), tiempoEjecucion);
		}else {
			log.info("Tiempo:{}ms", tiempoEjecucion);
		}
		
	}
	
}
