package com.bharatonjava.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;

public class DbcpConnectionPool {

	private static BasicDataSource dataSource;

	public static DataSource setupDataSource(String driverClass,
			String connectionUrl, String username, String password) {

		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClass);
		ds.setUrl(connectionUrl);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setMaxIdle(4);
		ds.setMaxActive(2);
		dataSource = ds;
		System.out.println("created pool");
		return ds;
	}

	public static void printDataSourceStats() {
		// BasicDataSource bds = (BasicDataSource) ds;
		System.out.println("NumActive: " + dataSource.getNumActive());
		System.out.println("NumIdle: " + dataSource.getNumIdle());
	}

	public static void shutdownDataSource(DataSource ds) throws SQLException {
		BasicDataSource bds = (BasicDataSource) ds;
		bds.close();
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
