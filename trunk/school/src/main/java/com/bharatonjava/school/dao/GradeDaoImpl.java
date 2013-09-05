package com.bharatonjava.school.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import com.bharatonjava.school.dao.mappers.GradeRowMapper;
import com.bharatonjava.school.domain.Grade;

public class GradeDaoImpl implements GradeDao {

	private static final Log log = LogFactory.getLog(GradeDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		SQLErrorCodeSQLExceptionTranslator tr = new SQLErrorCodeSQLExceptionTranslator();
		tr.setDataSource(dataSource);
		this.jdbcTemplate.setExceptionTranslator(tr);
	}

	@Override
	public List<Grade> getAllGrades() {

		List<Grade> grades = null;
		String sql = "select * from grade";
		grades = this.jdbcTemplate.query(sql, new GradeRowMapper());
		log.info("Returning " + grades != null? grades.size() : 0 + " grades");
		return grades;
	}

}
