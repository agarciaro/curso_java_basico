package com.sopra.equipo3.videoclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.equipo3.videoclub.model.entity.Ejemplar;
import com.sopra.equipo3.videoclub.repository.EjemplarRepository;

@Service
public class EjemplarServiceImp implements EjemplarService {

	@Autowired
	EjemplarRepository ejemplarRepository;

	@Override
	public List<Ejemplar> findAll() {
		return ejemplarRepository.findAll();
	}

	@Override
	public Ejemplar findById(Long id) {
		return ejemplarRepository.findById(id).get();
	}

	@Override
	public Ejemplar insert(Ejemplar ejemplar) {
		return ejemplarRepository.save(ejemplar);
	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		return ejemplarRepository.save(ejemplar);
	}

	@Override
	public void delete(Long id) {
		ejemplarRepository.deleteById(id);

	}

}
