package com.sopra.biblioteca.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sopra.biblioteca.model.JwtToken;
import com.sopra.biblioteca.service.JwtTokenUtil;
import com.sopra.biblioteca.service.UsuariDetalsService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter{
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	UsuariDetalsService usuariDetalsService;
	
	@Autowired
	JwtToken jwtToken;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {	
		
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);  //mira header
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {    // si no lleva token
			log.warn("No se ha podido extraer el token");
			filterChain.doFilter(request, response);
			return;
		}
		
		final String token = authHeader.split(" ")[1].trim();   //separa token d e la peticion
		
		String username = jwtTokenUtil.getUsernameFromToken(token);    //crea variable username con el user sacado del token
		 
		UserDetails userDetails = usuariDetalsService.loadUserByUsername(username); //crea userdetails con el nombre del usuario 
		
		log.info(" --- USERDETAILS:{}", userDetails);
		
		if(jwtTokenUtil.validateToken(token, userDetails)) {
			UsernamePasswordAuthenticationToken authenticationToken = 
					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());  //crea autenticacion con el token
			
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		
		jwtToken.setToken(token);
		
		filterChain.doFilter(request, response);
		
	}
	
	
	
}
