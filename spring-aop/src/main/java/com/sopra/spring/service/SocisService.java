package com.sopra.spring.service;

import java.util.List;

import com.sopra.spring.model.Socis;

public interface SocisService {

	List<Socis> getSocis();

	Socis insert(Socis soci);

}
