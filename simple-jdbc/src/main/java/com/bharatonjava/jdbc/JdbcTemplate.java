package com.bharatonjava.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import com.bharatonjava.jdbc.exceptions.JdbcConfigurationException;
import com.bharatonjava.jdbc.mappers.RowMapper;
import com.bharatonjava.transactions.TransactionAnnotationProcessor;

public abstract class JdbcTemplate {

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

	protected void beginTransaction(Connection c) throws SQLException{
		c.setAutoCommit(false);
	}
	
	protected void closeConnection(Connection c, Statement s, ResultSet rs)
			throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (s != null) {
			s.close();
		}
		if (c != null) {
			c.close();
		}
	}

	/**
	 * Template method
	 * 
	 * @param sql
	 * @throws SQLException
	 */
	public final <T> List<T> query(String sql, RowMapper<T> rowMapper)
			throws SQLException {

		Connection c = getConnection();
		List<T> lst = processQueryForList(c, sql, rowMapper);
		closeConnection(c, null, null);
		return lst;

	}

	protected abstract <T> List<T> processQueryForList(Connection c,
			String sql, RowMapper<T> rowMapper) throws SQLException;

	/**
	 * 
	 * @param sql
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public final <T> T queryForObject(String sql, RowMapper<T> rowMapper)
			throws SQLException {
		
		TransactionAnnotationProcessor.begin();
		
		Connection c = getConnection();
		T o = processQueryForObject(c, sql, rowMapper);
		closeConnection(c, null, null);
		return o;
	}

	protected abstract <T> T processQueryForObject(Connection c, String sql,
			RowMapper<T> rowMapper) throws SQLException;

	/**
	 * 
	 * @param sql
	 * @param values
	 * @return
	 * @throws SQLException
	 */
	public int executeInsert(String sql, Object[] values) throws SQLException {

		Connection c = getConnection();
		int status = 0;
		try {
			status = processExecuteInsert(c, sql, values);
		} catch (SQLException sqle) {
			throw sqle;
		} finally {
			closeConnection(c, null, null);
		}

		return status;
	}

	public abstract int processExecuteInsert(Connection c, String sql,
			Object[] values) throws SQLException;
	
	
	public void execute(String sql) throws SQLException{
		Connection c = getConnection();
		try{
			processExecute(c, sql);
		}finally{
			closeConnection(c, null, null);
		}
	}
	
	public abstract void processExecute(Connection c, String sql) throws SQLException;
	
}
