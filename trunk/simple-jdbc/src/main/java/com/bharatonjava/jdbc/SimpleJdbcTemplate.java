package com.bharatonjava.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bharatonjava.jdbc.exceptions.IncorrectResultsetSizeException;
import com.bharatonjava.jdbc.mappers.RowMapper;

public class SimpleJdbcTemplate extends JdbcTemplate {

	private static final Logger log = Logger
			.getLogger(SimpleJdbcTemplate.class);

	@Override
	protected <T> List<T> processQueryForList(Connection c, String sql,
			RowMapper<T> rowMapper) throws SQLException {

		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(sql);

		List<T> lst = new ArrayList<T>();

		while (rs.next()) {
			T o = rowMapper.mapRow(rs, rs.getRow());
			lst.add(o);
		}

		// close connections
		closeConnection(null, s, rs);

		return lst;
	}

	@Override
	protected <T> T processQueryForObject(Connection c, String sql,
			RowMapper<T> rowMapper) throws SQLException {
		log.info("Query: " + sql);

		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(sql);

		rs.last();
		int rowNum = rs.getRow();
		
		if (rowNum != 1) {
			throw new IncorrectResultsetSizeException(
					"Resultset returned more than one rows. Expected 1, returned "
							+ rowNum);
		}

		// fetch single object
		T o = rowMapper.mapRow(rs, rs.getRow());

		// close connections
		closeConnection(null, s, rs);

		return o;
	}

	@Override
	public int processExecuteInsert(Connection c, String sql, Object[] values)
			throws SQLException {

		log.info("Query: " + sql);

		PreparedStatement pst = c.prepareStatement(sql);
		for (int i = 0; i < values.length; i++) {
			if (values[i] instanceof Integer) {
				pst.setInt(i + 1, Integer.valueOf(String.valueOf(values[i])));
			} else if (values[i] instanceof String) {
				pst.setString(i + 1, String.valueOf(values[i]));
			}
		}

		int count = pst.executeUpdate();
		System.out.println("insert count:" + count);
		return count;
	}

	/**
	 * Executes simple sql statements like create table or an insert query with
	 * parameters appended as strings.
	 */
	@Override
	public void processExecute(Connection c, String sql) throws SQLException {

		log.info("Query: " + sql);
		Statement stmt = c.createStatement();
		boolean status = stmt.execute(sql);
		System.out.println("status: " + status);
	}

}
