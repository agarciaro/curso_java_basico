package com.sopra.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.biblioteca.model.Soci;
import com.sopra.biblioteca.reporsitory.SociRepository;

@Service
public class SocisServiceImpl implements SocisService {
	
	@Autowired
	SociRepository sociRepository;
	
	@Override
	public List<Soci> findAll() {
		return sociRepository.findAllOrderByCodi();
	}

	@Override
	public Soci findByCodi(Integer codi) {
		return sociRepository.findById(codi).get();
	}

	@Override
	public void delete(Integer codi) {
		sociRepository.deleteById(codi);		
	}

	@Override
	public Soci update(Soci soci) {
		return sociRepository.save(soci);
	}

	@Override
	public Soci insert(Soci soci) {
		return sociRepository.save(soci);
	}

}
