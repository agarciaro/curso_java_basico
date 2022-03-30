package com.sopra.biblioteca.reporsitory;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sopra.biblioteca.model.Soci;

@Repository
public interface SociRepository extends CrudRepository<Soci, Integer> {
	
	@Query("SELECT s FROM Soci s WHERE s.dataAlta <= :any")
	public List<Soci> findSocisInAny(@Param("any") LocalDate any);
	
	@Query("SELECT s FROM Soci s ORDER BY s.codi")
	public List<Soci> findAllOrderByCodi();
	
}
