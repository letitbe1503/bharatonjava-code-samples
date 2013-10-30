package com.bharatonjava.pms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MAIL_TEMPLATE")
public class MailTemplate {

	private Long templateId;
	private String templateTitle;
	private String templateText;

	public MailTemplate() {
	}

	@Id
	@Column(name = "TEMPLATE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	@Column(name = "TEMPLATE_TITLE")
	public void setTemplateTitle(String templateTitle) {
		this.templateTitle = templateTitle;
	}

	public void setTemplateText(String templateText) {
		this.templateText = templateText;
	}

	@Column(name = "TEMPLATE_TEXT", length = 4000)
	public String getTemplateText() {
		return templateText;
	}

	public String getTemplateTitle() {
		return templateTitle;
	}

}
