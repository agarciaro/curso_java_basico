package com.sopra.equipo4.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.equipo4.model.JwtToken;
import com.sopra.equipo4.service.JwtTokenUtil;
import com.sopra.equipo4.service.UsuarioDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    UsuarioDetailsService usuarioDetailsService;

    @Autowired
    JwtToken jwtToken;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        final String token = authHeader.split(" ")[1].trim();

        String username = jwtTokenUtil.getUsernameFromToken(token);

        UserDetails userDetails = usuarioDetailsService.loadUserByUsername(username);

        if(jwtTokenUtil.validateToken(token, userDetails)){
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        jwtToken.setToken(token);
        jwtToken.setUsername(username);
        
        filterChain.doFilter(request, response);
    }
    
}
