package com.sopra.videoclub.service;

import java.util.List;

import com.sopra.videoclub.model.Socio;


public interface SocioService {

	public List<Socio> findAll();
	public Socio findById();
	
}
