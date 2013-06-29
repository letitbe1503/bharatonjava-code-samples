package com.bharatonjava.school.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bharatonjava.school.domain.Student;

public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public StudentDaoImpl() {
	}

	@Override
	public void saveStudent(Student student) {

		Session session = this.sessionFactory.openSession();

		session.save(student);

	}

}
