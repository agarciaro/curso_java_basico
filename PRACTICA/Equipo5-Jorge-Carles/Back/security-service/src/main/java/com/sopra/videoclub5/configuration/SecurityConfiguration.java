package com.sopra.videoclub5.configuration;

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

import com.sopra.videoclub5.filter.JwtAuthenticationEntryPoint;
import com.sopra.videoclub5.filter.JwtTokenFilter;
import com.sopra.videoclub5.model.JwtToken;
import com.sopra.videoclub5.service.UsuarioDetailsService;

@Configuration
@EnableWebSecurity // Inicia la seguridad
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
@ConditionalOnProperty(name = "com.sopra.security.enabled", havingValue = "true", matchIfMissing = false)

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioDetailsService usuariDetalsService;

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
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { // Dices a Spring de donde tiene que
																					// sacar los datos para validar que
																					// eres tú
		auth.userDetailsService(usuariDetalsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Habilitar CORS y deshabilitar CSRF
		http = http.cors().and().csrf().disable();

		// Establecer el Session Management a STATELESS (Por ser Stateless no lo guardará en la Base de datos)
		http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and(); 

		// Establecer un Exception Handler para los REQUESTS no permitidos (Devuelve el 401)
		http = http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and();

		// Establecer permisos a los endpoints (Das los permisos a los usuarios)
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/login").permitAll()
			.antMatchers(HttpMethod.POST, "/api/registro").permitAll();
				//.anyRequest().authenticated(); Pide autenticación a todo

		// Añadir el filtro para procesar el token JWT
		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class); //Si tienes un token válido te dará permisos de entradas

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
