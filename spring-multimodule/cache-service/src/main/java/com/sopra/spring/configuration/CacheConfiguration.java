package com.sopra.spring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.sopra.spring.service.CacheManager;
import com.sopra.spring.service.CacheManagerLocal;

@Configuration
@ConditionalOnProperty(name = "sopra.cache.enabled", havingValue = "true")
public class CacheConfiguration {
	
	@Value("${sopra.cache.expiration-time:60000}")
	private Long expirationTime;
	
	@Value("${sopra.cache.remote:false}")
	private boolean isRemote;
	
//	@Bean("cacheManager")
//	@ConditionalOnProperty()
//	public CacheManager cacheManager() {
//		CacheManager cache = new CacheManagerLocal(expirationTime);
//		return cache;
//	}
	
	@Bean
	@ConditionalOnProperty(name = "sopra.cache.remote", havingValue = "true")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
