package com.sopra.biblioteca.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "com.sopra.scheduling.enabled", havingValue = "true")
public class SchedulingConfiguration {

}
