package com.sopra.equipoa.videoclub.model;

import org.springframework.data.domain.Pageable;

public interface Paginable extends Pageable{

	@Override
	default int getPageNumber() {
		return 0;
	}

	@Override
	default int getPageSize() {

		return 1;
	}
	
}
