package com.bharatonjava.pms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bharatonjava.pms.domain.Enquiry;

@Repository
public class EnquiryDaoImpl implements EnquiryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveEnquiry(Enquiry enquiry) {
		Session session = sessionFactory.getCurrentSession();
		session.save(enquiry);
	}

	@Override
	public List<Enquiry> getEnquiries() {
		Session session = sessionFactory.getCurrentSession();
		//List<Enquiry> lst = session.createQuery("from Enquiry e").list();
		List<Enquiry> lst = null;
		Criteria crit = session.createCriteria(Enquiry.class);
		crit.addOrder(Order.desc("enquiryId"));
		lst = crit.list();
		return lst;
	}

	@Override
	public Enquiry getEnquiryById(Long enquiryId){
		Session session = sessionFactory.getCurrentSession();
		Enquiry e = null;
		e = (Enquiry) session.get(Enquiry.class, enquiryId);
		return e;
	}
	
	
}
