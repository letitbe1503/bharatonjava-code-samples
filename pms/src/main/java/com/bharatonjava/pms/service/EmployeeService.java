package com.bharatonjava.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.pms.dao.EmployeeDao;
import com.bharatonjava.pms.domain.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeService() {
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Transactional
	public void saveEmployee(Employee employee){
		employeeDao.saveEmployee(employee);
	}
	
	@Transactional
	public List<Employee> getEmployees(){
		return employeeDao.getEmployees();
	}

}
