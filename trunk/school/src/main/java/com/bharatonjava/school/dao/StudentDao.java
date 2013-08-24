package com.bharatonjava.school.dao;

import java.util.List;

import com.bharatonjava.school.domain.Student;

public interface StudentDao {

	public int saveStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public Student getStudentById(Long studentId);
}