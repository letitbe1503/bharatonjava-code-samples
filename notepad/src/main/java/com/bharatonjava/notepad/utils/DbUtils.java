package com.bharatonjava.notepad.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {

	private DbUtils() {
	}

	public static final Connection getConnection() {

		return null;
	}

	public static final void closeResources(ResultSet rs, Statement stmt,
			Connection conn) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	
}
