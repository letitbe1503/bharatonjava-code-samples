package com.bharatonjava.pms.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.CloseEvent;
import org.springframework.stereotype.Component;

import com.bharatonjava.pms.domain.MailTemplate;
import com.bharatonjava.pms.service.MailService;

@Component
public class MailBean implements Serializable {

	private static final long serialVersionUID = -1706916554624402467L;

	private MailService mailService;
	private String mailText;
	private List<MailTemplate> mailTemplates;
	private MailTemplate selectedTemplate;

	public MailBean() {
		mailTemplates = new ArrayList<MailTemplate>();
		// mailTemplates = mailService.getMailTemplates();
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public String getMailText() {
		return mailText;
	}

	public void setMailText(String mailText) {
		this.mailText = mailText;
	}

	public List<MailTemplate> getMailTemplates() {
		return mailTemplates;
	}

	public void setMailTemplates(List<MailTemplate> mailTemplates) {
		this.mailTemplates = mailTemplates;
	}

	public MailTemplate getSelectedTemplate() {
		return selectedTemplate;
	}

	public void setSelectedTemplate(MailTemplate selectedTemplate) {
		this.selectedTemplate = selectedTemplate;
	}

	@PostConstruct
	public void intializePostConstruct() {
		udpateMailTemplates();
	}

	public void sendEmail() {
		System.out.println("mailText: " + mailText);
	}

	public void saveMailTemplate(ActionEvent actionEvent) {
		System.out.println("saveMailTemplate");

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Info", "Please provide Template name.");

		FacesContext.getCurrentInstance().addMessage(null, message);

		MailTemplate mailTemplate = new MailTemplate();
		mailTemplate.setTemplateText(mailText);
		mailTemplate.setTemplateTitle("Mail template test");
		System.out.println(mailTemplate.getTemplateText());
		mailService.saveMailTemplate(mailTemplate);
		udpateMailTemplates();
	}

	public void udpateMailTemplates() {
		mailTemplates = mailService.getMailTemplates();
	}

	public void deleteTemplate() {
		System.out.println("deleteTemplate");
		mailService.deleteTemplate(selectedTemplate.getTemplateId());
		udpateMailTemplates();
	}

	public void onRowSelect() {
		System.out.println("onRowSelect");
		mailText = selectedTemplate.getTemplateText();
	}

	public void onRowUnselect() {
		System.out.println("onRowUnselect");
	}

	public void destroyWorld(ActionEvent actionEvent) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"System Error", "Please try again later.");

		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void handleClose(CloseEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				" ", "Email template not saved.");
		context.addMessage(null, message);
	}
	
	public void handleCancel() {
		System.out.println("handleCancel");
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				" ", "Email template not saved.");
		context.addMessage(null, message);
	}
}
