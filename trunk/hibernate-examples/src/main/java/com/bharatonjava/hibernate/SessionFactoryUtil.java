package com.bharatonjava.hibernate;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class SessionFactoryUtil {

	private static org.hibernate.SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	//
	private SessionFactoryUtil() {

	}

}
