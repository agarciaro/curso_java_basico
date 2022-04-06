package com.sopra.equipo4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.equipo4.model.Alquiler;
import com.sopra.equipo4.model.AlquilerPK;
import com.sopra.equipo4.repository.AlquilerRepository;

@Service
public class AlquilerServiceImpl implements AlquilerService {
	
	@Autowired
	AlquilerRepository alquilerRepository;
	
	public List<Alquiler> findAll() {
		return (List<Alquiler>) alquilerRepository.findAll();
	}

	public Alquiler findById(AlquilerPK id) {
		return alquilerRepository.findById(id).get();
	}

	public void deleteAlquilerById(AlquilerPK id) {
		alquilerRepository.deleteById(id);
	}

	public Alquiler updateAlquiler(Alquiler alquiler) {
		return alquilerRepository.save(alquiler);
	}

	public Alquiler insertAlquiler(Alquiler alquiler) {
		return alquilerRepository.save(alquiler);
	}

}
