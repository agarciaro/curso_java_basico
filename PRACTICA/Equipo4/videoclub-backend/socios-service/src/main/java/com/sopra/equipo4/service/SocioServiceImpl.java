package com.sopra.equipo4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.equipo4.model.AsignacionSocio;
import com.sopra.equipo4.model.Socio;
import com.sopra.equipo4.repository.AsignacionSocioRepository;
import com.sopra.equipo4.repository.SocioRepository;
@Service
public class SocioServiceImpl implements SocioService {
	
	@Autowired
	SocioRepository socioRepository;
	
	@Autowired
	AsignacionSocioRepository asignacionSocioRepository;
	
	@Autowired
	UtilsService utilsService;

	@Override
	public List<Socio> findAll() {
		return (List<Socio>) socioRepository.findAll();
	}

	@Override
	public Socio findById(Integer id) {
		return socioRepository.findById(id).get();
	}

	@Override
	public void deleteSocioById(Integer id) {
		socioRepository.deleteById(id);
	}

	@Override
	public Socio updateSocio(Socio socio) {
		return socioRepository.save(socio);
	}

	@Override
	public Socio insertSocio(Socio socio) {
				
		Socio nuevoSocio = socioRepository.save(socio);
		
		AsignacionSocio asignacionSocio = new AsignacionSocio(nuevoSocio, utilsService.generateCode());
		
		asignacionSocioRepository.save(asignacionSocio);
		
		return nuevoSocio;
	}

}
