package com.bharatonjava.pms.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bharatonjava.pms.domain.Enquiry;
import com.bharatonjava.pms.service.EnquiryService;

@Component
public class EnquiryBean implements Serializable{

	private static final long serialVersionUID = -7031919946544049132L;

	private Enquiry enquiry;

	private List<Integer> bhks;
	private Map<String, String> maritalStatuses;
	private List<Enquiry> enquiries;
	
	private Enquiry enquiryDetailed;
	
	@Autowired
	public EnquiryService enquiryService;
	
	public EnquiryBean() {
		enquiry = new Enquiry();

		bhks = new ArrayList<>();
		bhks.add(1);
		bhks.add(2);
		bhks.add(3);
		bhks.add(4);
		bhks.add(5);
		bhks.add(6);

		maritalStatuses = new HashMap<String, String>();
		maritalStatuses.put("Married", "M");
		maritalStatuses.put("Un-Married", "U");

		enquiries = new ArrayList<Enquiry>();
		
	}

	@PostConstruct
	public void initialize(){
		enquiries = enquiryService.getEnquiries();
	}
	
	public Enquiry getEnquiry() {
		return enquiry;
	}

	public void setEnquiry(Enquiry enquiry) {
		this.enquiry = enquiry;
	}

	public List<Integer> getBhks() {
		return bhks;
	}

	public Map<String, String> getMaritalStatuses() {
		return maritalStatuses;
	}

	public void setEnquiryService(EnquiryService enquiryService) {
		this.enquiryService = enquiryService;
	}
	
	public Enquiry getEnquiryDetailed() {
		return enquiryDetailed;
	}
	
	public String saveEnquiry() {
		System.out.println("enquiry: " + enquiry);
		enquiry.setEnquiryDate(new Date());
		enquiryService.saveEnquiry(enquiry);
		
		return "viewEnquiries";
	}
	
	public String viewEnquiry(Long enquiryId){
		System.out.println("enquiryId: "+enquiryId);
		enquiryDetailed = enquiryService.getEnquiryById(enquiryId);
		return "viewEnquiry";
	}
	
	public List<Enquiry> getEnquiries() {
		return enquiries;
	}
	
	public void getAllEnquiries(){
		enquiries = enquiryService.getEnquiries();
	}
}
