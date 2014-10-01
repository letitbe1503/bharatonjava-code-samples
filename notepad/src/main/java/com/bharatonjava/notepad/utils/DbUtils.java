package com.bharatonjava.notepad.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbUtils {

	private static final Logger log = LoggerFactory.getLogger(DbUtils.class);

	private static DataSource ds;

	static {
		Context initContext = null;
		Context envContext = null;
		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/notepad");
		} catch (NamingException e) {
			log.error("Error in initializer.", e);
		}
	}

	private DbUtils() {
	}

	public static final Connection getConnection() throws SQLException,
			ClassNotFoundException {
		Connection conn = ds.getConnection();
		return conn;
	}

	public static final void closeResources(ResultSet rs, Statement stmt,
			Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			log.error("Exception while closing database resources", e);
		}
	}

}
