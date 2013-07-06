package com.bharatonjava.school.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GRADE")
public class Grade {

	private Long gradeId;
	private String gradeName;
	private Set<Student> students = new HashSet<Student>();

	public Grade() {
	}

	@Id
	@Column(name = "GRADE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getGradeId() {
		return gradeId;
	}

	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}

	@Column(name = "GRADE_NAME")
	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "GRADE_ID")
	//@JoinTable(name = "GRADE_STUDENT", joinColumns = { @JoinColumn(name = "GRADE_ID") }, inverseJoinColumns = { @JoinColumn(name = "STUDENT_ID") })
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
