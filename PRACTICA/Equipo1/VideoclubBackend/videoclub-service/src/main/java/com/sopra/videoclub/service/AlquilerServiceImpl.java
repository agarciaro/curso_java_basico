package com.sopra.videoclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.videoclub.model.Alquiler;
import com.sopra.videoclub.repository.AlquilerRepository;

@Service
public class AlquilerServiceImpl implements AlquilerService {

	@Autowired
	AlquilerRepository alquilerRepository;

	@Override
	public List<Alquiler> findAllAlquileres() {
		return (List<Alquiler>) alquilerRepository.findAll();
	}

	@Override
	public Alquiler findAlquilerById(Integer id) {
		return alquilerRepository.findById(id).get();
	}

	@Override
	public void deleteAlquiler(Integer id) {
		alquilerRepository.deleteById(id);

	}

	@Override
	public Alquiler updateAlquiler(Alquiler alquiler) {
		return alquilerRepository.save(alquiler);
	}

	@Override
	public Alquiler insertAlquiler(Alquiler alquiler) {
		return alquilerRepository.save(alquiler);
	}

}
