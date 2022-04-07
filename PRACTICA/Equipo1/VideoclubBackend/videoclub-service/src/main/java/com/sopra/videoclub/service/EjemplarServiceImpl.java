package com.sopra.videoclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.videoclub.model.Ejemplar;
import com.sopra.videoclub.repository.EjemplarRepository;

@Service
public class EjemplarServiceImpl implements EjemplarService {

	@Autowired
	EjemplarRepository ejemplarRepository;

	@Override
	public List<Ejemplar> findAllEjemplares() {
		return (List<Ejemplar>) ejemplarRepository.findAll();
	}

	@Override
	public Ejemplar findEjemplarById(Integer id) {
		return ejemplarRepository.findById(id).get();
	}

	@Override
	public void deleteEjemplar(Integer id) {
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