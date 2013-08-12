package com.bharatonjava;

import org.hibernate.Session;

import com.bharatonjava.domain.City;
import com.bharatonjava.domain.Grade;
import com.bharatonjava.domain.State;
import com.bharatonjava.domain.Student;
import com.bharatonjava.hibernate.SessionFactoryUtil;

public class MainClass {

	private void go() {

		//addState();
		 addCity();
		// addGrade();
		getGrade();
		// addStudent();
		getStudent();

	}

	public static void main(String[] args) {
		new MainClass().go();
		System.out.println("done!");
	}

	protected void addGrade() {
		Session session = SessionFactoryUtil.getSession();
		session.beginTransaction();
		Grade g = new Grade(2L, "Junior KG");
		session.save(g);
		session.getTransaction().commit();
	}

	protected void getGrade() {
		Session session = SessionFactoryUtil.getSession();
		session.beginTransaction();
		Grade g = (Grade) session.get(Grade.class, 1L);
		session.getTransaction().commit();
		System.out.println(g);
	}

	protected void addStudent() {
		Session session = SessionFactoryUtil.getSession();
		session.beginTransaction();
		Student s = new Student();
		s.setFirstName("Bharat");
		s.setLastName("Sharma");
		// grade
		Grade g = (Grade) session.get(Grade.class, 2L);
		s.setGrade(g);

		session.save(s);
		session.getTransaction().commit();
	}

	protected void getStudent() {

		Session session = SessionFactoryUtil.getSession();
		session.beginTransaction();
		Student s = (Student) session.get(Student.class, 1L);
		session.getTransaction().commit();
		System.out.println(s);
	}

	protected void addState() {

		Session session = SessionFactoryUtil.getSession();
		session.beginTransaction();
		State s = new State(1L, "Maharashtra");
		session.save(s);
		session.getTransaction().commit();
	}

	protected void addCity() {

		Session session = SessionFactoryUtil.getSession();
		session.beginTransaction();
		City c = new City(1L, "Mumbai");
		State s = (State) session.get(State.class, 1L);
		c.setState(s);
		session.save(c);
		session.getTransaction().commit();
	}

}
