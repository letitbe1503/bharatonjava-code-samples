package com.bharatonjava.pms.dao;

import java.util.List;

import com.bharatonjava.pms.domain.Enumeration;

public interface EnumerationDao {

	public List<Enumeration> getEnumerationsByGroup(String enumGroup);
	
	public void addEnumeration(Enumeration enumeration);
}
