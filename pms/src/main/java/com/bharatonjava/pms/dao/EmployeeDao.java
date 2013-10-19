package com.bharatonjava.pms.dao;

import java.util.List;

import com.bharatonjava.pms.domain.Employee;

public interface EmployeeDao {

	public void saveEmployee(Employee employee);
	
	public List<Employee> getEmployees();
}
