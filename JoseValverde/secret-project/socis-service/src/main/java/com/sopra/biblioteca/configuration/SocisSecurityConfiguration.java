package com.sopra.biblioteca.configuration;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sopra.biblioteca.filter.JwtTokenFilter;
import com.sopra.biblioteca.service.UsuariDetalsService;

@Configuration
@EnableWebSecurity
public class SocisSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuariDetalsService usuariDetalsService;
	
	@Autowired
	JwtTokenFilter jwtTokenFilter;
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuariDetalsService);
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
					(request, response, ex) -> {
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
					}
				)
				.and();
		
		//Establecer permisos a los endpoints
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
			.antMatchers(HttpMethod.GET, "/api/auth/password/*/encode").permitAll()
			.anyRequest().authenticated();
		
		//Añadir el filtro para procesar el token JWT
		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
