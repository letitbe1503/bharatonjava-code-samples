package com.bharatonjava.pms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.bharatonjava.pms.domain.Enumeration;

public class EnumerationDaoImpl implements EnumerationDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Enumeration> getEnumerationsByGroup(String enumGroup) {

		List<Enumeration> enumerations = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Enumeration.class);
		crit.add(Restrictions.like("enumGroup", enumGroup));
		enumerations = crit.list();
		return enumerations;
	}
	
	@Override
	public void addEnumeration(Enumeration enumeration){
		
		Session session = sessionFactory.getCurrentSession();
		session.save(enumeration);
	}
}
