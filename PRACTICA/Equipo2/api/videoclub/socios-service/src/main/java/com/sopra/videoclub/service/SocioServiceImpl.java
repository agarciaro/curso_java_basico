package com.sopra.videoclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.videoclub.model.Socio;
import com.sopra.videoclub.repository.SocioRepository;

@Service
public class SocioServiceImpl implements SocioService{

	@Autowired
	SocioRepository socioRepository;

	@Override
	public List<Socio> findAll() {
		return (List<Socio>) socioRepository.findAll();
	}

	@Override

	public Socio findById(Integer id) {
		 return socioRepository.findById(id).get();
	}

	@Override
	public Socio insertSocio(Socio socio) {
		return socioRepository.save(socio);
	}

	@Override
	public Socio updateSocio(Socio socio) {
		return socioRepository.save(socio);
	}

	@Override
	public void deleteSocio(Integer id) {
		socioRepository.deleteById(id);	
	}
	
	
}
