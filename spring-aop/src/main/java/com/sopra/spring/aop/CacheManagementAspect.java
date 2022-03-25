package com.sopra.spring.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.sopra.spring.annotation.Cacheame;
import com.sopra.spring.exception.CacheException;
import com.sopra.spring.service.CacheManager;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@ConditionalOnProperty(name = "sopra.cache.enabled", havingValue = "true")
@Slf4j
public class CacheManagementAspect {
	
	@Autowired
	@Qualifier("cacheManager")
	CacheManager cache;
	
	@Around("@annotation(com.sopra.spring.annotation.Cacheame)")
	public Object cacheaDatos(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature =(MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Cacheame annotation = method.getAnnotation(Cacheame.class);
		String cacheName = annotation.nombre();
		
		try {
			Object e = cache.getCacheValue(cacheName);
			log.debug("Cache found! Getting result from cache");
			return e;
		} catch (CacheException e) {
			log.warn("Cache miss:{}", e.getMessage());
		} 
		
		Object respuesta = joinPoint.proceed();
		cache.insertValue(cacheName, respuesta);
		
		return respuesta;
		
	}
	
}
