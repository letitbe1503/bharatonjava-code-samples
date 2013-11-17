package com.bharatonjava.pms.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.pms.dao.EnumerationDao;
import com.bharatonjava.pms.domain.Enumeration;
import com.bharatonjava.pms.util.Constants;

public class ExpenseService {
	
	private EnumerationDao enumerationDao;
	
	
	public void setEnumerationDao(EnumerationDao enumerationDao) {
		this.enumerationDao = enumerationDao;
	}

	@Transactional
	public void addExpenseType(Enumeration expenseType){
		enumerationDao.addEnumeration(expenseType);
	}
	
	@Transactional
	public List<Enumeration> getExpenseTypes(){
		return enumerationDao.getEnumerationsByGroup(Constants.EXPENSE_TYPE);
	}
	
}
