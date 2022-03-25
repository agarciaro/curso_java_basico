package com.sopra.spring.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.spring.exception.CacheEvictedException;
import com.sopra.spring.exception.CacheExpiredException;
import com.sopra.spring.exception.CacheNotFoundException;
import com.sopra.spring.service.CacheManager;

@RestController
@RequestMapping("/api/cache")
public class CacheRestController{
	
	@Autowired
	CacheManager cacheManager;
	
	@DeleteMapping("/{name}")
	public void evict(@PathVariable String name) throws CacheNotFoundException {
		cacheManager.evict(name);
	}

	@GetMapping("/{name}")
	public Object getCacheValue(@PathVariable String name) throws CacheNotFoundException, CacheEvictedException, CacheExpiredException {
		return cacheManager.getCacheValue(name);
	}

	@PostMapping("/{name}")
	public void insertValue(@PathVariable String name, @RequestBody Object value) {
		cacheManager.insertValue(name, value);	
	}
	
	@GetMapping
	public Set<String> getCacheNames(){
		return cacheManager.getCacheNames();
	}
	
}
