package com.sopra.equipo1.videoclub.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sopra.videoclub.model.Usuario;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsuarioDetails extends Usuario implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9214714911650487762L;

	public UsuarioDetails() {}
	
	public UsuarioDetails(Usuario usuario) {
		super.setUsername(usuario.getUsername());
		super.setPassword(usuario.getPassword());
		super.setRoles(usuario.getRoles());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		log.info("ROLES:{}", super.getRoles());
		return super.getRoles().stream().map((rol) -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}
	
	

}
