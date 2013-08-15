package com.bharatonjava.school.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "GRADE")
public class Grade {

	private Long gradeId;
	private String gradeName;

	private Set<Student> students = new HashSet<Student>();

	public Grade() {
	}

	public Grade(Long gradeId, String gradeName) {
		this.gradeId = gradeId;
		this.gradeName = gradeName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRADE_ID")
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

	@OneToMany(mappedBy = "grade", fetch= FetchType.LAZY)
	@OrderBy(value = "grade")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Grade [gradeId=" + gradeId + ", gradeName=" + gradeName
				+ ", students=" + students.size() + "]";
	}

}
