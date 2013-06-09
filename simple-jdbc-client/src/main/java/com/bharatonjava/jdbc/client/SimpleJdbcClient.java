package com.bharatonjava.jdbc.client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bharatonjava.jdbc.JdbcTemplate;
import com.bharatonjava.jdbc.SimpleJdbcTemplate;
import com.bharatonjava.jdbc.mappers.RowMapper;
import com.bharatonjava.transactions.DoInTransaction;

public class SimpleJdbcClient {

	public static void main(String[] args) throws SQLException {

		new SimpleJdbcClient().go();
		
	}

	public void go() throws SQLException {

		JdbcTemplate template = new SimpleJdbcTemplate();

		// executeInsert(template);
		System.out.println("------------------------------------");
		// getListOfObjects(template);
		System.out.println("------------------------------------");
		getSingleObject(template);
		
		
	}

	public void executeInsert(JdbcTemplate template) throws SQLException{
		
		template.executeInsert("insert into contacts (contact_id, building) values (?,?)", new Object[]{5,"Ventura"});
	}
	
	public void getListOfObjects(JdbcTemplate template) throws SQLException {
		// Query for list
		List<Contact> lst = template.query(
				"select contact_id, building from contacts",
				new RowMapper<Contact>() {

					@Override
					public Contact mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Contact c = new Contact();
						c.setContactId(rs.getLong("contact_id"));
						c.setBuilding(rs.getString("building"));
						return c;
					}
				});

		System.out.println("List of objects"+lst);
	}

	@DoInTransaction
	public void getSingleObject(JdbcTemplate template) throws SQLException {
		// query for single Object
		Contact c = template.queryForObject(
				"select contact_id, building from contacts where contact_id=5",
				new RowMapper<Contact>() {

					@Override
					public Contact mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Contact c = new Contact();
						c.setContactId(rs.getLong("contact_id"));
						c.setBuilding(rs.getString("building"));
						return c;
					}
				});

		System.out.println("Single object: " + c);
	}
}
