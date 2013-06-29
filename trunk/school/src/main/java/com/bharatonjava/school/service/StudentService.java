package com.bharatonjava.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.school.dao.StudentDao;
import com.bharatonjava.school.domain.Student;

public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Transactional
	public void saveStudent(Student student) {
		studentDao.saveStudent(student);
	}
	
	@Transactional
	public List<Student> getAllStudents(){
		return studentDao.getAllStudents();
	}
}
