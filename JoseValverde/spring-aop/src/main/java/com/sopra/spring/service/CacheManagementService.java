package com.sopra.spring.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sopra.spring.exception.CacheEvictedException;
import com.sopra.spring.exception.CacheNotFoundException;
import com.sopra.spring.model.CacheElement;

@Service
public class CacheManagementService {
	
	private Map<String, CacheElement> container = new HashMap<>();
	
	public void evict(String cacheName) throws CacheNotFoundException{
		CacheElement element = null;
		try {
			element = getCache(cacheName);
		} catch (CacheEvictedException e) {
			return;
		}
		element.setValid(false);
	}
	
	private CacheElement getCache(String cacheName) throws CacheNotFoundException, CacheEvictedException{
		CacheElement element = container.get(cacheName);
		if(element == null) {
			throw new CacheNotFoundException();
		}
		if(!element.isValid()) {
			throw new CacheEvictedException();
		}
		return element;
	}
	
	public Object getCacheValue(String cacheName) throws CacheNotFoundException, CacheEvictedException{
		return getCache(cacheName).getElement();
	}
	
	public void insertValue(String cacheName, Object value) {
		CacheElement cacheElement = new CacheElement(value, true);
		container.put(cacheName, cacheElement);
	}
	
}
