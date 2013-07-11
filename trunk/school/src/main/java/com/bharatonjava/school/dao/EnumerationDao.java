package com.bharatonjava.school.dao;

import java.util.List;

import com.bharatonjava.school.domain.Enumeration;

public interface EnumerationDao {

	public List<Enumeration> getEnumerations(String enumGroup);
	
}
