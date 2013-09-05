package com.bharatonjava.school.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import com.bharatonjava.school.dao.mappers.EnumerationRowMapper;
import com.bharatonjava.school.domain.Enumeration;

public class EnumerationDaoImpl implements EnumerationDao{

	private static final Log log = LogFactory.getLog(EnumerationDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		SQLErrorCodeSQLExceptionTranslator tr = new SQLErrorCodeSQLExceptionTranslator();
		tr.setDataSource(dataSource);
		this.jdbcTemplate.setExceptionTranslator(tr);
	}

	
	public List<Enumeration> getEnumerations(String enumGroup){

		String sql = "select enum_id,enum_group,enum_value from enumerations where enum_group = ?";
		List<Enumeration> enumerations = null;
		enumerations = this.jdbcTemplate.query(sql, new EnumerationRowMapper(), new Object[]{enumGroup});
		log.info("Returning "+ enumerations != null? enumerations.size() : 0 + " Enumerations");
		return enumerations;
	}
}
