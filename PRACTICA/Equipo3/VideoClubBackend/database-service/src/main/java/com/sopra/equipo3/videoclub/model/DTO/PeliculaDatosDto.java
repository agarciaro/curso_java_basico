package com.sopra.equipo3.videoclub.model.DTO;

import java.util.ArrayList;
import java.util.List;

import com.sopra.equipo3.videoclub.model.entity.Actor;
import com.sopra.equipo3.videoclub.model.entity.Director;
import com.sopra.equipo3.videoclub.model.entity.Pelicula;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaDatosDto {
	
	private Pelicula pelicula;
    private List<Actor> actores = new ArrayList<Actor>();
	private List<Director> directores = new ArrayList<Director>();
	
}
