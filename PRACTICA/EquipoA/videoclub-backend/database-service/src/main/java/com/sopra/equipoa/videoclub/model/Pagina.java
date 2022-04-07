package com.sopra.equipoa.videoclub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagina {
	private int page = 0;
	private int size = 10;
}
