package br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/cadastroCervejaria";
			return DriverManager.getConnection(url,"root","84116593");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
}