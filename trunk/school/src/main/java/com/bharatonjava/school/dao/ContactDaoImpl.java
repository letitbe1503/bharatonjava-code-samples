package com.bharatonjava.school.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bharatonjava.school.domain.Contact;

public class ContactDaoImpl implements ContactDao {

	private static final Log log = LogFactory.getLog(ContactDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int saveContact(Contact contact) {
		String sql = "insert into contact(building,street,area,city,state)values(?,?,?,?,?)";
		int count = this.jdbcTemplate.update(
				sql,
				new Object[] { contact.getBuilding(), contact.getStreet(),
						contact.getArea(), contact.getCity(),
						contact.getState() });
		log.info("Contact saved "+ count);
		return count;
	}

	@Override
	public int deleteContact(Long contactId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contact getContactById(Long contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

}
