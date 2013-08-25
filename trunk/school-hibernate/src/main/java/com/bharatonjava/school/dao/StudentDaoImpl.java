package com.bharatonjava.school.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.bharatonjava.school.domain.Fee;
import com.bharatonjava.school.domain.Student;

public class StudentDaoImpl implements StudentDao {

	private static final Log log = LogFactory.getLog(StudentDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public StudentDaoImpl() {
	}

	@Override
	public void saveStudent(Student student) {

		Session session = sessionFactory.getCurrentSession();
		session.save(student);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {

		List<Student> students = null;
		Session session = sessionFactory.getCurrentSession();
		students = session.createQuery("from Student").list();
		log.info("Returning " + students != null ? students.size()
				: 0 + " Students");
		return students;
	}

	public Student getStudentById(Long studentId) {

		Student s = null;
		Session session = sessionFactory.getCurrentSession();
		s = (Student) session.get(Student.class, studentId);
		log.info(s);
		return s;
	}

	@Override
	public List<Fee> getFeeByStudentId(Long studentId) {
		Session session = sessionFactory.getCurrentSession();
		List<Fee> fees = null;
		Criteria crit = session.createCriteria(Fee.class).add(
				Restrictions.eq("student.studentId", studentId));
		fees = crit.list();
		return fees;
	}

	@Override
	public void saveStudentFee(Fee fee) {
		Session session = sessionFactory.getCurrentSession();
		session.save(fee);
	}

}
