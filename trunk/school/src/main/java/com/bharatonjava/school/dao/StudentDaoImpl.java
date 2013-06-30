package com.bharatonjava.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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
		session.flush();
		session.close();
	}

	@Override
	public List<Student> getAllStudents() {
		Session session = this.sessionFactory.openSession();
		List<Student> lst = null;
		// lst = session.createQuery("from Student").list();
		Criteria crit = session.createCriteria(Student.class);
		crit.addOrder(Order.asc("firstName"));
		lst = crit.list();
		session.flush();
		session.close();
		return lst;
	}

}
