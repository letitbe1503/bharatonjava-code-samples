package com.bharatonjava.pms.dao;

import java.util.List;

import com.bharatonjava.pms.domain.Enquiry;

public interface EnquiryDao {

	public void saveEnquiry(Enquiry enquiry);
	
	public List<Enquiry> getEnquiries();
}
