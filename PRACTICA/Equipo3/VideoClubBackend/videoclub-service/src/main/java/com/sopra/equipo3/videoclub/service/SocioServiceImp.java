package com.sopra.equipo3.videoclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.equipo3.videoclub.model.Socio;
import com.sopra.equipo3.videoclub.repository.SocioRepository;

@Service
public class SocioServiceImp implements SocioService{
	
	@Autowired
	SocioRepository socioRepository;
	
	@Override
	public List<Socio> findAll() {
		return socioRepository.findAll();
	}

	@Override
	public Socio findById(Long id) {
		return socioRepository.findById(id).get();
	}

	@Override
	public Socio insert(Socio socio) {
		return socioRepository.save(socio);
	}

	@Override
	public Socio update(Socio socio) {
		return socioRepository.save(socio);
	}

	@Override
	public void delete(Long id) {
		socioRepository.deleteById(id);
		
	}

}
