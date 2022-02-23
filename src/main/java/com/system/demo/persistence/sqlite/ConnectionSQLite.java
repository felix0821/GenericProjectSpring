package com.system.demo.persistence.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionSQLite {
	
	private String url = "system.db";
	private Connection connection;
	
	public void openConnect() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"+url);
			if(connection!=null) {
				System.out.println("Conexion exitosa");
			}
		} catch(SQLException e) {
			System.out.println("Error de conexion: "+e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnect() {
		try {
			connection.close();
			System.out.println("Conexion finalizada");
		} catch(SQLException e) {
			Logger.getLogger(ConnectionSQLite.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
