package com.sopra.equipoa.videoclub.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sopra.equipoa.videoclub.model.Pagina;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PaginationParseFilter extends OncePerRequestFilter{
		
	@Autowired
	Pagina pagina;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {	
		
		try {
			log.info("----- QUERY PARAMS:{}", request.getQueryString());
			if(request.getQueryString() != null && !request.getQueryString().isEmpty()) {
				String[] fields = request.getQueryString().split("&");
				for (String field : fields) {
					String[] claveValor = field.split("=");
					if(claveValor[0].equals("page")) {
						pagina.setPage(Integer.parseInt(claveValor[1]));
					}
					if(claveValor[0].equals("size")) {
						pagina.setSize(Integer.parseInt(claveValor[1]));
					}
				}
			
				
			}
		} catch (Exception e) {
			log.warn("Error al parsear paginación de query params");
		}		
		
		filterChain.doFilter(request, response);
	}
	
	
	
}
