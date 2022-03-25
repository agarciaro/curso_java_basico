package com.sopra.spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sopra.spring.model.Socis;

@Repository("socisRepository")
public class SocisRepositoryImpl implements SocisRepository{
	
	@Autowired
	@Qualifier("namedParameterJdbcTemplate")
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Socis> findAll() {
		String sql = "SELECT * FROM socis";
		return jdbcTemplate.query(sql, new RowMapper<Socis>() {

			@Override
			public Socis mapRow(ResultSet rs, int rowNum) throws SQLException {
				Socis soci = new Socis();
				soci.setCodi(rs.getInt("codi"));
				soci.setAdreca(rs.getString("adreca"));
				soci.setDataAlta(rs.getDate("data_alta") != null?rs.getDate("data_alta").toLocalDate():null);
				
				return soci;
			}
		});
	}

	@Override
	public Socis findById(Integer id) {
		String sql = "SELECT * FROM socis WHERE codi = :id";
		
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Socis.class));
	}

	@Override
	public Socis insert(Socis element) {
		String sql = "INSERT INTO socis VALUES(:codi, :nom, :cognom, :dni, :adreca, :codiPostal, :ciutat, :provincia, :telefon, :dataAlta)";
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(element);
		
		jdbcTemplate.update(sql, params);
		return findById(element.getCodi());
	}

	@Override
	public Socis update(Socis element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
