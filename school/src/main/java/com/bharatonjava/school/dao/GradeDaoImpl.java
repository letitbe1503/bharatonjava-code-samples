package com.bharatonjava.school.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bharatonjava.school.domain.Grade;

public class GradeDaoImpl implements GradeDao {

	private static final Log log = LogFactory.getLog(GradeDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Grade> getAllGrades() {
		Session session = sessionFactory.openSession();
		List<Grade> grades = session.createQuery("from Grade").list();
		log.info("Returning "+ grades != null? grades.size() : 0 +" Grades");
		return grades;
	}

}
