package com.sopra.biblioteca.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuariDetails extends Usuari implements UserDetails{

	private static final long serialVersionUID = -3443505686188951096L;
	
	
	public UsuariDetails() {}
	
	public UsuariDetails(Usuari usuari) {
		super.setUsername(usuari.getUsername());
		super.setPassword(usuari.getPassword());
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
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
