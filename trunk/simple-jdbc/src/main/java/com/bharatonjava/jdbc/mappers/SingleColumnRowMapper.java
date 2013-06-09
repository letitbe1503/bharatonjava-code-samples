package com.bharatonjava.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.bharatonjava.jdbc.exceptions.IncorrectResultSetColumnCountException;

public class SingleColumnRowMapper<T> implements RowMapper<T> {

	private Class<T> requiredType;

	public SingleColumnRowMapper() {
	}

	public SingleColumnRowMapper(Class<T> requiredType) {
		this.requiredType = requiredType;
	}

	public void setRequiredType(Class<T> requiredType) {
		this.requiredType = requiredType;
	}

	@Override
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {

		ResultSetMetaData rsmd = rs.getMetaData();

		int colCount = rsmd.getColumnCount();

		if (colCount != 1) {
			throw new IncorrectResultSetColumnCountException(
					"Resultset has incorrect coulum count.", 1, colCount);
		}

		// fetch column value from resultset
		Object result = rs.getObject(1);

		if (result != null && this.requiredType != null
				&& !this.requiredType.isInstance(result)) {

			return (T) result;
		}
		// do checked casting here. Baically write a utility method to check
		// instaceof and then do casting for known java types.
		return (T) result;
	}

}
