package com.bharatonjava.school.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.school.domain.Contact;

public class ContactRowMapper implements RowMapper<Contact>{

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact c = new Contact();
		c.setContactId(rs.getLong("CONTACT_ID"));
		c.setStudentId(rs.getLong("STUDENT_ID"));
		c.setBuilding(rs.getString("BUILDING"));
		c.setStreet(rs.getString("STREET"));
		c.setArea(rs.getString("AREA"));
		c.setCity(rs.getString("CITY"));
		c.setState(rs.getString("STATE"));
		return c;
	}

}
