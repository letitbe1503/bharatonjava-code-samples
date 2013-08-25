package com.bharatonjava.school.dao;

import java.util.List;

import com.bharatonjava.school.domain.Fee;
import com.bharatonjava.school.domain.Student;

public interface StudentDao {

	public void saveStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public Student getStudentById(Long studentId);
	
	public List<Fee> getFeeByStudentId(Long studentId);
	
	public void saveStudentFee(Fee fee);
}
