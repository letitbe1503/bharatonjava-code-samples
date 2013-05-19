package com.bharatonjava.jdbc;

import java.sql.SQLException;


public class MainTestClass {

	public static void main(String[] args) throws SQLException{
		
		SimpleJdbcTemplate t = new SimpleJdbcTemplate();
		
		t.executeQuery();
	}
}
