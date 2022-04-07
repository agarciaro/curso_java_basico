package com.sopra.videoclub.service;

import java.util.List;

import com.sopra.videoclub.model.Alquiler;

public interface AlquilerService {

	public List<Alquiler> findAllAlquileres();

	public Alquiler findAlquilerById(Integer id);

	public void deleteAlquiler(Integer id);

	public Alquiler updateAlquiler(Alquiler alquiler);

	public Alquiler insertAlquiler(Alquiler alquiler);

}