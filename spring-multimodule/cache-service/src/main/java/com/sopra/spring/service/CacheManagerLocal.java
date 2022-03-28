package com.sopra.spring.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

import com.sopra.spring.exception.CacheEvictedException;
import com.sopra.spring.exception.CacheExpiredException;
import com.sopra.spring.exception.CacheNotFoundException;
import com.sopra.spring.model.CacheElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@ConditionalOnExpression("${sopra.cache.enabled} == true and ${sopra.cache.remote} == false")
@NoArgsConstructor
//@AllArgsConstructor
@Slf4j
public class CacheManagerLocal implements CacheManager{
	
	private Map<String, CacheElement> container = new HashMap<>();
	@Getter
	private Long expirationTime = 30L * 1000; //En milisegundos
	
	public CacheManagerLocal(Long expirationTime) {
		super();
		this.expirationTime = expirationTime;
	}
	
	@PostConstruct
	public void init() {
		log.info("Cache iniciada: expiration set to {}ms", expirationTime);
	}
	
	@Override
	public void evict(String cacheName) throws CacheNotFoundException{
		log.debug("Cache {} evicted", cacheName);
		CacheElement element = null;
		try {
			element = getCache(cacheName);
		} catch (CacheEvictedException e) {
			return;
		}
		element.setValid(false);
	}
	
	private CacheElement getCache(String cacheName) throws CacheNotFoundException, CacheEvictedException, CacheExpiredException{
		CacheElement element = container.get(cacheName);
		if(element == null) {
			throw new CacheNotFoundException("No se ha encontrado la cache");
		}
		if(isExpired(element)) {
			throw new CacheExpiredException("La cache ha expirado");
		}
		if(!element.isValid()) {
			throw new CacheEvictedException("La cache no es válida");
		}
		return element;
	}
	
	@Override
	public Object getCacheValue(String cacheName) throws CacheNotFoundException, CacheEvictedException, CacheExpiredException{
		log.debug("Getting Value from Cache {}", cacheName);
		return getCache(cacheName).getElement();
	}
	
	@Override
	public void insertValue(String cacheName, Object value) {
		log.debug("Cache {} created", cacheName);
		CacheElement cacheElement = new CacheElement(value);
		container.put(cacheName, cacheElement);
	}
	
	private boolean isExpired(CacheElement element) {
		long diff = System.currentTimeMillis() - element.getCreationTime();
		return (diff > this.expirationTime)?true:false;
	}

	@Override
	public Set<String> getCacheNames() {
		return container.keySet();
	}

	@Override
	public String getMode() {
		return "LOCAL";
	}
	
}
