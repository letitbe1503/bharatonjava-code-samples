package com.bharatonjava.pms.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

import com.bharatonjava.pms.domain.Enquiry;

@Component
@SessionScoped
@ManagedBean(name = "enquiry")
public class EnquiryBean {

	public Enquiry enquiry;
	
	public EnquiryBean() {
		enquiry = new Enquiry();
	}
	
	public Enquiry getEnquiry() {
		return enquiry;
	}
	
	public void setEnquiry(Enquiry enquiry) {
		this.enquiry = enquiry;
	}
}
