package com.bharatonjava.school.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.school.domain.Enumeration;

public class EnumerationRowMapper implements RowMapper<Enumeration>{

	@Override
	public Enumeration mapRow(ResultSet rs, int rownum) throws SQLException {
		Enumeration e = new Enumeration();
		e.setEnumId(rs.getInt("enum_id"));
		e.setEnumGroup(rs.getString("enum_group"));
		e.setEnumValue(rs.getString("enum_value"));
		return e;
	}

	
}
