package com.bharatonjava.school.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.school.domain.Student;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rownum) throws SQLException {
		Student s = new Student();
		s.setStudentId(rs.getLong("STUDENT_ID"));
		s.setFirstName(rs.getString("FIRST_NAME"));
		s.setMiddleName(rs.getString("MIDDLE_NAME"));
		s.setLastName(rs.getString("LAST_NAME"));
		s.setDob(rs.getDate("DATE_OF_BIRTH"));
		return s;
	}

}
