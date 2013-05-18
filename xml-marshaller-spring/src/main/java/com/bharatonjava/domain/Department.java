package com.bharatonjava.domain;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private String name;

	private List<Employee> employees = new ArrayList<Employee>();

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", employees=" + employees + "]";
	}

}
