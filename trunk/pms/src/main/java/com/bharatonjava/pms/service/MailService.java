package com.bharatonjava.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.pms.dao.MailDao;
import com.bharatonjava.pms.domain.MailTemplate;

@Service
public class MailService {
	
	@Autowired
	private MailDao mailDao;
	
	public void setMailDao(MailDao mailDao) {
		this.mailDao = mailDao;
	}
	
	@Transactional
	public void saveMailTemplate(MailTemplate mailTemplate){
		mailDao.saveMailTemplate(mailTemplate);
	}
	
	@Transactional
	public List<MailTemplate> getMailTemplates(){
		return mailDao.getMailTemplates();
	}
	
	@Transactional
	public void deleteTemplate(Long templateId){
		mailDao.deleteTemplate(templateId);
	}
}
