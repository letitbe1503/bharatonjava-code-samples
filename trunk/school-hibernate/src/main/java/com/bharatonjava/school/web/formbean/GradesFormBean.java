package com.bharatonjava.school.web.formbean;

import java.util.List;

import com.bharatonjava.school.domain.Grade;

public class GradesFormBean {

	private Grade grade;
	
	private List<Grade> grades;
	
	public Grade getGrade() {
		return grade;
	}
	
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	public List<Grade> getGrades() {
		return grades;
	}
	
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "GradesFormBean [grade=" + grade + ", grades=" + grades + "]";
	}
	
}
