package com.bharatonjava.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bharatonjava.jdbc.mappers.RowMapper;

public class SimpleJdbcTemplate extends JdbcTemplate {

	@Override
	protected void process(Connection conn, String sql) throws SQLException {
		Statement stmt = conn.createStatement();
		System.out.println("process....");
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("building"));
		}
	}

	@Override
	protected void process(Connection conn, String sql, RowMapper rowMapper)
			throws SQLException {
		Statement stmt = conn.createStatement();
		System.out.println("process....");
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("building"));
		}
	}

}
