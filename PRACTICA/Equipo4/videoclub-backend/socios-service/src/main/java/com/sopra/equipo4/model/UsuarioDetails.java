package com.sopra.equipo4.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioDetails extends Usuario implements UserDetails {

	private static final long serialVersionUID = -6798288947453487053L;
	
	public UsuarioDetails() {
		
	}
	
	public UsuarioDetails(Usuario usuario) {
		super.setUsername(usuario.getUsername());
		super.setPassword(usuario.getPassword());
		super.setRoles(usuario.getRoles());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return super.getRoles().stream().map((rol) -> 
			new SimpleGrantedAuthority(rol.getNombre()))
				.collect(Collectors.toList());
	}
	
	public String getPassword() {
		return super.getPassword();
	}
	
	public String getUsername() {
		return super.getUsername();
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
	
}
