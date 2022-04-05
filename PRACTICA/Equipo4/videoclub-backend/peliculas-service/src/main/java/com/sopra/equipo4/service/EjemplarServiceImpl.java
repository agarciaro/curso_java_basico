package com.sopra.equipo4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.equipo4.model.Ejemplar;
import com.sopra.equipo4.repository.EjemplarRepository;

@Service
public class EjemplarServiceImpl implements EjemplarService {
	@Autowired
	EjemplarRepository ejemplarRepository;

	@Override
	public List<Ejemplar> findAll() {
		return (List<Ejemplar>) ejemplarRepository.findAll();
	}

	@Override
	public Ejemplar findById(Integer id) {
		return ejemplarRepository.findById(id).get();
	}

	@Override
	public void deleteEjemplarById(Integer id) {
		ejemplarRepository.deleteById(id);
	}

	@Override
	public Ejemplar updateEjemplar(Ejemplar ejemplar) {
		return ejemplarRepository.save(ejemplar);
	}

	@Override
	public Ejemplar insertEjemplar(Ejemplar ejemplar) {
		return ejemplarRepository.save(ejemplar);
	}

}
