package com.bharatonjava.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.pms.dao.EnquiryDao;
import com.bharatonjava.pms.domain.Enquiry;

public class EnquiryService {
	
	
	@Autowired
	private EnquiryDao enquiryDao;
	
	public void setEnquiryDao(EnquiryDao enquiryDao) {
		this.enquiryDao = enquiryDao;
	}
	
	@Transactional
	public void saveEnquiry(Enquiry enquiry){
		enquiryDao.saveEnquiry(enquiry);
	}
	
	@Transactional
	public List<Enquiry> getEnquiries(){
		return enquiryDao.getEnquiries();
	}
	
	@Transactional
	public Enquiry getEnquiryById(Long enquiryId){
		return enquiryDao.getEnquiryById(enquiryId);
	}
	
}
