package com.sopra.spring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sopra.spring.service.CacheManager;

@Configuration
@ConditionalOnProperty(name = "sopra.cache.enabled", havingValue = "true")
public class CacheConfiguration {
	
	@Value("${sopra.cache.expiration-time:60000}")
	private Long expirationTime;
	
	@Bean("cacheManager")
	public CacheManager cacheManager() {
		CacheManager cache = new CacheManager(expirationTime);
		return cache;
	}
	
//	@Bean("cacheManager2")
//	public CacheManager cacheManager2() {
//		CacheManager cache = new CacheManager();
//		return cache;
//	}
	
}
