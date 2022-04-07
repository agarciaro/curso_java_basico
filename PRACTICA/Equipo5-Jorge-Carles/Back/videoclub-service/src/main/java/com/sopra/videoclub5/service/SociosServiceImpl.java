package com.sopra.videoclub5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.videoclub5.modelEntity.Socio;
import com.sopra.videoclub5.repository.SocioRepository;

@Service
public class SociosServiceImpl implements SociosService {

	@Autowired
	SocioRepository socioRepository;

	@Override
	public List<Socio> findAll() {
		return (List<Socio>) socioRepository.findAll();
	}

	@Override
	public Socio findByNumSocio(Integer codi) {
		return socioRepository.findById(codi).get();
	}

	@Override
	public void delete(Integer codi) {
		socioRepository.deleteById(codi);
	}

	@Override
	public Socio update(Socio soci) {
		return socioRepository.save(soci);
	}

	@Override
	public Socio insert(Socio soci) {
		return socioRepository.save(soci);
	}

}
