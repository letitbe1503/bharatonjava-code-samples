package com.bharatonjava.pms.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bharatonjava.pms.domain.Employee;
import com.bharatonjava.pms.service.EmployeeService;

@Component
public class EmployeeBean implements Serializable{

	private static final long serialVersionUID = 23995862074839537L;

	private Employee employee;
	
	private List<Employee> employees;
	
	private EmployeeService employeeService;
	
	public EmployeeBean() {
		employee = new Employee();
		employees = new ArrayList<Employee>();
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public String saveEmployee(){
		employeeService.saveEmployee(employee);
		return "";
	}

	public void initEmployees(){
		employees = employeeService.getEmployees();
	}
}
