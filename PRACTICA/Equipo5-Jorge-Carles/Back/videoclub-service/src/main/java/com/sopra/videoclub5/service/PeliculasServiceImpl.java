//package com.sopra.videoclub5.service;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sopra.videoclub5.model.Pelicula;
//import com.sopra.videoclub5.repository.PeliculaRepository;
//
//@Service
//public class PeliculasServiceImpl implements PeliculasService {
//
//	@Autowired
//	PeliculaRepository peliculasRepository;
//
//	@Override
//	public List<Pelicula> findAll() {
//
//		return (List<Pelicula>) peliculasRepository.findAll();
//	}
//
//	@Override
//	public Pelicula findById(Integer id) {
//
//		return peliculasRepository.findById(id).orElseThrow(new DataAcce);
//	}
//
//	@Override
//	public Pelicula findByNombre(String nombre) {
//
//		return peliculasRepository.fi(nombre);
//	}
//
//	@Override
//	public void deleteById(Integer id) {
//		peliculasRepository.deleteById(id);
//	}
//
//	@Override
//	public void deleteByNombre(String nombre) {
//		peliculasRepository.deleteByNombre(nombre);
//	}
//
//	@Override
//	public Pelicula update(Pelicula pelicula) {
//
//		return peliculasRepository.update(pelicula);
//	}
//
//	@Override
//	public Pelicula insert(Pelicula pelicula) {
//
//		return peliculasRepository.insert(pelicula);
//	}
//
//}
