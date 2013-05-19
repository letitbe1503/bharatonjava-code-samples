package com.bharatonjava.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class JdbcTemplate {

	protected Connection getConnection() throws SQLException {

		DbcpConnectionPool.setupDataSource("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/test", "root", "");
		DbcpConnectionPool.printDataSourceStats();
		return DbcpConnectionPool.getConnection();
	}

	protected void closeConnection() {
		System.out.println("close connection");
	}

	public final void executeQuery() throws SQLException {
		Connection c = getConnection();
		process(c);
		closeConnection();
	}

	protected abstract void process(Connection c) throws SQLException;

}
