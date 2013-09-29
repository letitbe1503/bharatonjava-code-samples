package com.bharatonjava.domain.cache;

import java.sql.Connection;
import java.sql.SQLException;

public class CacheImpl implements Cache {

	public void initialize() throws SQLException {
		System.out.println("Intializing Cache.");
		Connection conn = ConnectionManager.getConnection();
		
	}

}
