package com.sopra.spring.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sopra.spring.exception.CacheEvictedException;
import com.sopra.spring.exception.CacheExpiredException;
import com.sopra.spring.exception.CacheNotFoundException;
import com.sopra.spring.model.CacheElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@ConditionalOnExpression("${sopra.cache.enabled} == true and ${sopra.cache.remote} == true")
@NoArgsConstructor
//@AllArgsConstructor
@Slf4j
public class CacheManagerRemote implements CacheManager{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${sopra.cache.base-url}")
	String baseUrl;
	
	@PostConstruct
	public void init() {
		log.info("Cache Remota iniciada");
	}
	
	@Override
	public void evict(String cacheName) throws CacheNotFoundException{
		String url = baseUrl + "/" + cacheName;
		try {
			restTemplate.delete(url);
		} catch (RestClientException e) {
			throw new CacheNotFoundException("Cache no encontrada");
		}
	}
	
	@Override
	public Object getCacheValue(String cacheName) throws CacheNotFoundException, CacheEvictedException, CacheExpiredException{
		log.info("URL:{}", baseUrl + "/" + cacheName);
//		return getCache(cacheName).getElement();
		try {
			return restTemplate.getForObject(baseUrl + "/" + cacheName, Object.class);
		} catch (RestClientException e) {
			throw new CacheNotFoundException("Cache no encontrada o evicteada");
		}
	}
	
	@Override
	public void insertValue(String cacheName, Object value) {
//		CacheElement cacheElement = new CacheElement(value);
		restTemplate.postForEntity(baseUrl + "/" + cacheName, value, String.class);
//		restTemplate.ex
//		container.put(cacheName, cacheElement);
	}
	
	@Override
	public Set<String> getCacheNames() {
		return restTemplate.getForObject(baseUrl, Set.class);
	}

	@Override
	public String getMode() {
		return "REMOTE";
	}
	
}
