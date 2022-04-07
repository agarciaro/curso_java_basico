package com.sopra.videoclub5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sopra.videoclub5.model.Director;
import com.sopra.videoclub5.model.Socio;

@Service
public interface DirectorService {

	public List<Director> findAll();

	public Director findByNumSocio(Integer codi);

	public void delete(Integer codi);

	public Director update(Director soci);

	public Director insert(Director soci);
}
