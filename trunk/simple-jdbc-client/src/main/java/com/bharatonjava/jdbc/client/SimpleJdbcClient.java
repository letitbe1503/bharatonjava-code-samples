package com.bharatonjava.jdbc.client;

import java.sql.SQLException;

import com.bharatonjava.jdbc.JdbcTemplate;
import com.bharatonjava.jdbc.SimpleJdbcTemplate;

public class SimpleJdbcClient {

	public static void main(String[] args) throws SQLException {
		
		JdbcTemplate template = new SimpleJdbcTemplate();
		template.executeQuery("select * from contacts");

	}

}
