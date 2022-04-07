package com.sopra.videoclub.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sopra.videoclub.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsuarioDetails extends Usuario implements UserDetails {
	
	
	public UsuarioDetails(){};
	
	public UsuarioDetails(Usuario usuario) {
		super.setUsername(usuario.getUsername());
		super.setPassword(usuario.getPassword());
		super.setRoles(usuario.getRoles());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		log.info("ROLES:{}",super.getRoles());
		return super.getRoles().stream()
				.map((rol)->new SimpleGrantedAuthority(
						rol.getNombre()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
