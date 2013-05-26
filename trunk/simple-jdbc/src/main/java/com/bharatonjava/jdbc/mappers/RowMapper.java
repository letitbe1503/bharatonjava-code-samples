package com.bharatonjava.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  Implementations must implement this method to map each row of data in the ResultSet.
 * @author Bharat sharma
 *
 */
public interface RowMapper {

	Object mapRow(ResultSet rs, int rowNum) throws SQLException;
	
}
