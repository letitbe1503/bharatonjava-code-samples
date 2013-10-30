package com.bharatonjava.pms.dao;

import java.util.List;

import com.bharatonjava.pms.domain.MailTemplate;

public interface MailDao {

	public void saveMailTemplate(MailTemplate mailTemplate);
	
	public List<MailTemplate> getMailTemplates();
	
	public void deleteTemplate(Long templateId);
	
}
