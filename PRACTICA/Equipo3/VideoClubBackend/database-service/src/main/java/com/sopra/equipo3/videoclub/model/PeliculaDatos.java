package com.sopra.equipo3.videoclub.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaDatos {
	
	private Pelicula pelicula;
    private List<Actor> actores = new ArrayList<Actor>();
	private List<Director> directores = new ArrayList<Director>();
	
}
