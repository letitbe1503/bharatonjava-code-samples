package com.bharatonjava.school.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.school.domain.Grade;

public class GradeRowMapper implements RowMapper<Grade> {

	@Override
	public Grade mapRow(ResultSet rs, int rownum) throws SQLException {
		Grade g = new Grade();
		g.setGradeId(rs.getLong("GRADE_ID"));
		g.setGradeName(rs.getString("GRADE_NAME"));
		return g;
	}

}
