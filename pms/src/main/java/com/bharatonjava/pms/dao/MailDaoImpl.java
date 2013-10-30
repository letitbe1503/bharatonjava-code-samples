package com.bharatonjava.pms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bharatonjava.pms.domain.MailTemplate;

@Repository
public class MailDaoImpl implements MailDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void saveMailTemplate(MailTemplate mailTemplate){
		Session session = sessionFactory.getCurrentSession();
		session.save(mailTemplate);
	}

	@Override
	public List<MailTemplate> getMailTemplates() {
		Session session = sessionFactory.getCurrentSession();
		List<MailTemplate> mailTemplates = session.createQuery("from MailTemplate").list();
		return mailTemplates;
	}
	
	@Override
	public void deleteTemplate(Long templateId){
		Session session = sessionFactory.getCurrentSession();
		MailTemplate mailTemplate = (MailTemplate) session.get(MailTemplate.class, templateId);
		session.delete(mailTemplate);
	}
}
