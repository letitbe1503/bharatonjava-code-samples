package com.bharatonjava.jdbc.client;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bharatonjava.jdbc.JdbcTemplate;
import com.bharatonjava.jdbc.SimpleJdbcTemplate;
import com.bharatonjava.jdbc.mappers.RowMapper;

public class SimpleJdbcClient {

	public static void main(String[] args) throws SQLException {

		JdbcTemplate template = new SimpleJdbcTemplate();
		template.executeQuery("select * from contacts",
				new RowMapper<Contact>() {

					public Contact mapRow(ResultSet rs, int rowNum)
							throws SQLException {
							Contact c= new Contact();
							c.contactId = rs.getLong("contact_id");
							c.building = rs.getString("building");
						return c;
					}

				});

	}

}
