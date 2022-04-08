package com.sopra.equipo1.videoclub.filter;

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

import com.sopra.equipo1.videoclub.model.JwtToken;
import com.sopra.equipo1.videoclub.service.JwtTokenUtil;
import com.sopra.equipo1.videoclub.service.JwtUserDetailsService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@Autowired
	JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	JwtToken jwtToken;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			log.warn("No se ha podidio extraer el token");
			filterChain.doFilter(request, response);
			return;
		}

		final String token = authHeader.split(" ")[1].trim();

		String username = jwtTokenUtil.getUsernameFromToken(token);
		UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);

		log.info(" --- USERDETAILS:{}", userDetails);

		if (jwtTokenUtil.validateToken(token, userDetails)) {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}

		jwtToken.setToken(token);
		jwtToken.setUsername(username);
		filterChain.doFilter(request, response);
	}
}
