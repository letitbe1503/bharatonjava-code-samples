package com.bharatonjava.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.bharatonjava.jdbc.exceptions.JdbcConfigurationException;
import com.bharatonjava.jdbc.mappers.RowMapper;

public abstract class JdbcTemplate<T> {

	private final String PROP_FILE = "simple-jdbc.properties";

	private Properties loadConfiguration() throws JdbcConfigurationException {

		Properties props = new Properties();
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream(PROP_FILE);

		if (inputStream == null) {
			throw new JdbcConfigurationException("File " + PROP_FILE
					+ " not found in classpath");
		}

		try {
			props.load(inputStream);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return props;
	}

	protected Connection getConnection() throws SQLException {
		Properties props = null;

		try {
			props = loadConfiguration();
			String driver = props.getProperty("jdbc.driver");
			if (driver == null) {
				throw new JdbcConfigurationException(
						"Property jdbc.driver not found in " + PROP_FILE
								+ " file.");
			}
			String url = props.getProperty("jdbc.url");
			if (url == null) {
				throw new JdbcConfigurationException(
						"Property jdbc.url not found in " + PROP_FILE
								+ " file.");
			}
			String username = props.getProperty("jdbc.username");
			if (username == null) {
				throw new JdbcConfigurationException(
						"Property jdbc.username not found in " + PROP_FILE
								+ " file.");
			}
			String password = props.getProperty("jdbc.password");
			if (password == null) {
				throw new JdbcConfigurationException(
						"Property jdbc.password not found in " + PROP_FILE
								+ " file.");
			}

			DbcpConnectionPool.setupDataSource(driver, url, username, password);

		} catch (JdbcConfigurationException e) {
			e.printStackTrace();
		}

		// DbcpConnectionPool.setupDataSource("com.mysql.jdbc.Driver",
		// "jdbc:mysql://localhost:3306/test", "root", "");
		DbcpConnectionPool.printDataSourceStats();
		return DbcpConnectionPool.getConnection();
	}

	protected void closeConnection() {
		System.out.println("close connection");
	}

	/**
	 * Template method
	 * 
	 * @param sql
	 * @throws SQLException
	 */
	public final void executeQuery(String sql) throws SQLException {
		Connection c = getConnection();
		//process(c, sql);
		closeConnection();
	}

	/**
	 * Template method with rowmapper.
	 * 
	 * @param sql
	 * @param rowMapper
	 * @throws SQLException
	 */
	public final void executeQuery(String sql, RowMapper<T> rowMapper)
			throws SQLException {
		System.out.println("11111");
		Connection c = getConnection();
		process(c, sql, rowMapper);
		closeConnection();
	}
	
	public List<T> query(String sql, RowMapper<T> rowMapper) throws SQLException{
		Connection c = getConnection();
		processQuery(c, sql, rowMapper);
		return null;
	}

	protected abstract void processQuery(Connection c, String sql, RowMapper<T> rowMapper);
	
	protected abstract <T> List<T> process(Connection c, String sql, RowMapper<T> rowMapper)
			throws SQLException;

}
