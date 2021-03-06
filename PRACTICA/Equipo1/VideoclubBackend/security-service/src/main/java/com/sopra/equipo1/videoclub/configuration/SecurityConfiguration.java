package com.sopra.equipo1.videoclub.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.WebApplicationContext;

import com.sopra.equipo1.videoclub.filter.JwtAuthenticationEntryPoint;
import com.sopra.equipo1.videoclub.filter.JwtTokenFilter;
import com.sopra.equipo1.videoclub.model.JwtToken;
import com.sopra.equipo1.videoclub.service.JwtUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
	securedEnabled = true,
	jsr250Enabled = true,
	prePostEnabled = true
)
@ConditionalOnProperty(name = "com.sopra.security.enabled", havingValue = "true", matchIfMissing = false)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	@Autowired
	JwtTokenFilter jwtTokenFilter;
	
	@Autowired
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Habilitar CORS y deshabilitar CSRF
		http = http.cors().and().csrf().disable();
				
		//Establecer el Session Management a STATELESS
		http = http.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and();
		
		//Establecer un Exception Handler para los REQUESTS no permitidos
		http = http.exceptionHandling()
				.authenticationEntryPoint(
						jwtAuthenticationEntryPoint
				)
				.and();
		
		//Establecer permisos a los endpoints
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/api/login").permitAll()
//			.antMatchers(HttpMethod.GET, "/api/auth/password/*/encode").permitAll()
			.antMatchers(HttpMethod.POST, "/api/registro").permitAll();
//			.anyRequest().authenticated();
		
		//A??adir el filtro para procesar el token JWT
		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public JwtToken jwtToken() {
		return new JwtToken();
	}
	
}
