package com.sopra.biblioteca.configuration;

import java.util.concurrent.Executor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
@ConditionalOnProperty(name = "com.sopra.async.enabled", havingValue = "true")
public class AsyncConfiguration {

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);
		executor.setMaxPoolSize(3);
		executor.setQueueCapacity(12);
		executor.setThreadNamePrefix("Bibli_async-");
		executor.initialize();
		return executor;
	}
}
