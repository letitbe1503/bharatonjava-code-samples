package com.bharatonjava.school.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bharatonjava.school.domain.Contact;

public class ContactDaoImpl implements ContactDao {

	private static final Log LOG = LogFactory.getLog(ContactDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Long saveContact(final Contact contact) {

		Session session = sessionFactory.getCurrentSession();
		session.save(contact);
		return 0L;
	}

	@Override
	public int deleteContact(Long contactId) {
		Session session = sessionFactory.getCurrentSession();
		Contact c = (Contact) session.get(Contact.class, contactId);
		session.delete(c);
		return 0;
	}

	@Override
	public int updateContact(Contact contact) {
		Session session = sessionFactory.getCurrentSession();
		session.update(contact);
		return 0;
	}

	@Override
	public Contact getContactById(Long contactId) {
		Session session = sessionFactory.getCurrentSession();
		Contact c = (Contact) session.get(Contact.class, contactId);
		return c;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Contact> getAllContacts() {
		Session session = sessionFactory.getCurrentSession();
		List<Contact> contacts = session.createQuery("from Contact").list(); 
		return contacts;
	}

	@Override
	public Contact getContactByStudentId(Long studentId) {
		
		return null;
	}

}
