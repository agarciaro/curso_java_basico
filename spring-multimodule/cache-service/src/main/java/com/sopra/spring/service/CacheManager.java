package com.sopra.spring.service;

import java.util.Set;

import com.sopra.spring.exception.CacheEvictedException;
import com.sopra.spring.exception.CacheExpiredException;
import com.sopra.spring.exception.CacheNotFoundException;

public interface CacheManager {
	
	public void evict(String cacheName) throws CacheNotFoundException;
	public Object getCacheValue(String cacheName) throws CacheNotFoundException, CacheEvictedException, CacheExpiredException;
	public void insertValue(String cacheName, Object value);
	public Set<String> getCacheNames();
	
	public String getMode();
	
}
