package com.bharatonjava.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.bharatonjava.school.dao.mappers.ContactRowMapper;
import com.bharatonjava.school.domain.Contact;

public class ContactDaoImpl implements ContactDao {

	private static final Log LOG = LogFactory.getLog(ContactDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Long saveContact(final Contact contact) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
			
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			String sql = "insert into contact(building,street,area,city,state)values(?,?,?,?,?,?)";
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql, new String[]{"contact_id"});
				ps.setLong(1, contact.getStudentId());
				ps.setString(2, contact.getBuilding());
				ps.setString(3, contact.getStreet());
				ps.setString(4, contact.getArea());
				ps.setString(5, contact.getCity());
				ps.setString(6, contact.getState());
				return ps;
			}
		}, keyHolder);
		
		LOG.info("contact saved with id: " + keyHolder.getKey().longValue());
		return keyHolder.getKey().longValue();
	}

	@Override
	public int deleteContact(Long contactId) {
		
		String sql = "delete from contact where contact_id=?"; 
		int count = this.jdbcTemplate.update(sql, new Object[]{contactId});
		return count;
	}

	@Override
	public int updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contact getContactById(Long contactId) {
		
		String sql = "select * from contact where contact_id=?";
		Contact c = this.jdbcTemplate.queryForObject(sql, new Object[]{contactId}, new ContactRowMapper());
		return c;
	}

	@Override
	public List<Contact> getAllContacts() {
		
		String sql = "select * from contact";
		List<Contact> contacts = this.jdbcTemplate.query(sql, new ContactRowMapper());
		return contacts;
	}

	@Override
	public Contact getContactByStudentId(Long studentId) {
		
		String sql = "select * from contact where student_id=?";
		Contact c = this.jdbcTemplate.queryForObject(sql, new Object[]{studentId}, new ContactRowMapper());
		return c;
	}

}
