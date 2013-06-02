package com.bharatonjava.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bharatonjava.jdbc.mappers.RowMapper;

public class SimpleJdbcTemplate extends JdbcTemplate {

	@Override
	protected void processQuery(Connection c, String sql, RowMapper rowMapper) {
		// TODO Auto-generated method stub

	}

	@Override
	protected List process(Connection c, String sql, RowMapper rowMapper)
			throws SQLException {
		System.out.println("2222");

		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<?> lst = null;

		while (rs.next()) {
			Object o = rowMapper.mapRow(rs, rs.getRow());
			//lst.add(o);
			System.out.println(o);
		}
		return lst;
	}

	

	/*
	 * @Override protected void process(Connection conn, String sql,
	 * RowMapper<T> rowMapper) throws SQLException { Statement stmt =
	 * conn.createStatement(); System.out.println("process...."); ResultSet rs =
	 * stmt.executeQuery(sql); while (rs.next()) {
	 * System.out.println(rs.getString("building")); } }
	 */

}
