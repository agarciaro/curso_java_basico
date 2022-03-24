package com.sopra.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.spring.annotation.Cacheame;
import com.sopra.spring.annotation.CacheameEvict;
import com.sopra.spring.model.Socis;
import com.sopra.spring.repository.SocisRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SocisServiceImpl implements SocisService {
	
	@Autowired
	SocisRepository socisRepository;
	
	@Cacheame(nombre = "socis")
	@Override
	public List<Socis> getSocis() {
		log.info("Dentro de Service getSocis");
		return (List<Socis>) socisRepository.findAll();
	}
	
	@CacheameEvict(nombre = "socis")
	@Override
	public Socis insert(Socis soci) {
		return socisRepository.save(soci);
	}

}
