package com.sopra.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//spring.datasource.url=jdbc:mysql://localhost:3306/spring
//spring.datasource.username=root
//spring.datasource.password=admin

public class JavaJdbcMain {
	
	public static final String URL = "jdbc:mysql://localhost:3306/spring";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "admin";
	public static final String DRIVER_CLASSNAME = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName(DRIVER_CLASSNAME);
		
		try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();
		) {
			
			try {
				connection.beginRequest();
				connection.setAutoCommit(false);
				var num = 50;
				String queryInsert = "INSERT INTO persona (id, nombre, edad) VALUES (" + num + ", 'Miguel Marronero', 50)";
				statement.executeUpdate(queryInsert);
				connection.commit();
				num = 60;
				statement.executeUpdate(queryInsert);
				connection.beginRequest();
				statement.executeUpdate(queryInsert);
				connection.endRequest();
				
				String querySelect = "SELECT id, nombre as name, edad FROM persona";
				ResultSet rs = statement.executeQuery(querySelect);
				
				while (rs.next()) {
					Persona p = new Persona();
					p.setId(rs.getLong("id"));
					p.setNombre(rs.getString("name"));
					p.setEdad(rs.getInt("edad"));
					
					System.out.println(p);
					
				}
				connection.commit();
			} catch (Exception e) {
				connection.rollback();
				throw e;
			}finally {
				connection.endRequest();
			}
			
		} catch (SQLException e) {
			System.err.println("Error accediendo a la BD: " + e.getMessage());
		}
//		System.out.println("OK");
	}

}
