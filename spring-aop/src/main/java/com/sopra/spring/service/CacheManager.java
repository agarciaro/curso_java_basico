package com.sopra.spring.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.sopra.spring.exception.CacheEvictedException;
import com.sopra.spring.exception.CacheExpiredException;
import com.sopra.spring.exception.CacheNotFoundException;
import com.sopra.spring.model.CacheElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
//@AllArgsConstructor
@Slf4j
public class CacheManager {
	
	private Map<String, CacheElement> container = new HashMap<>();
	@Getter
	private Long expirationTime = 30L * 1000; //En milisegundos
	
	public CacheManager(Long expirationTime) {
		super();
		this.expirationTime = expirationTime;
	}
	
	@PostConstruct
	public void init() {
		log.info("Cache iniciada: expiration set to {}ms", expirationTime);
	}
	
	public void evict(String cacheName) throws CacheNotFoundException{
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
			throw new CacheNotFoundException();
		}
		if(isExpired(element)) {
			throw new CacheExpiredException();
		}
		if(!element.isValid()) {
			throw new CacheEvictedException();
		}
		return element;
	}
	
	public Object getCacheValue(String cacheName) throws CacheNotFoundException, CacheEvictedException, CacheExpiredException{
		return getCache(cacheName).getElement();
	}
	
	public void insertValue(String cacheName, Object value) {
		CacheElement cacheElement = new CacheElement(value);
		container.put(cacheName, cacheElement);
	}
	
	private boolean isExpired(CacheElement element) {
		long diff = System.currentTimeMillis() - element.getCreationTime();
		return (diff > this.expirationTime)?true:false;
	}
	
}
