package com.bharatonjava.jdbc.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DatasourceUtils {

	public static Connection doGetConnection(DataSource dataSource) throws SQLException {

		if(null == dataSource)
		{
			assert dataSource != null : "No DataSource specified";
		}
		
		Connection conn = dataSource.getConnection();
		
		return conn;
		
	}
}
