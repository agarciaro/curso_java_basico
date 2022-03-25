package com.sopra.spring.repository;

import java.util.List;

public interface CrudSopraRepository<E, PK> {
	
	public List<E> findAll();
	public E findById(PK id);
	public E insert(E element);
	public E update(E element);
	public void delete(PK id);
//	public void deleteElement(E element);
	
}
