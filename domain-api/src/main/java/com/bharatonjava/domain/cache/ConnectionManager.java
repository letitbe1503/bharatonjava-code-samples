package com.bharatonjava.domain.cache;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ConnectionManager {

	private static DataSource dataSource = null;
	
	public ConnectionManager() {
	
	}
	
	public void setDataSource(DataSource dataSource) {
		ConnectionManager.dataSource = dataSource;
	}
	
	public static Connection getConnection() throws SQLException{
		
		Connection conn = dataSource.getConnection();
		
		return conn;
	}
	
	
}
