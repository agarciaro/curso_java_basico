package com.sopra.videoclub5.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sopra.videoclub5.modelEntity.Usuario;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsuarioDetails extends Usuario implements UserDetails {

	private static final long serialVersionUID = -3443505686188951096L;

	public UsuarioDetails() {
	}

	public UsuarioDetails(Usuario usuario) {
		super.setUsername(getUsername());
		super.setPassword(getPassword());
		super.setRoles(getRoles());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		log.info("ROLES:{}", super.getRoles());
		return super.getRoles().stream().map((rol) -> new SimpleGrantedAuthority(rol.getNombre()))
				.collect(Collectors.toList());
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
