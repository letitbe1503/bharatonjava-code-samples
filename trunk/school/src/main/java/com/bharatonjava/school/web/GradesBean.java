package com.bharatonjava.school.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

import com.bharatonjava.school.domain.Grade;

@Component
@ManagedBean(name = "gradesBean", eager = true)
@SessionScoped
public class GradesBean implements Serializable {

	private static final long serialVersionUID = -596594212822490948L;

	private List<Grade> grades = new ArrayList<Grade>();
	
	private Long gradeId;
	private String gradeName;
	
	public GradesBean() {
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public String submitGradesForm() {
		System.out.println(gradeId +"-"+ gradeName);
		grades.add(new Grade(gradeId,gradeName));
		return "grades";
	}
	
	public Long getGradeId() {
		return gradeId;
	}
	
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	
	public String getGradeName() {
		return gradeName;
	}
	
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
}
