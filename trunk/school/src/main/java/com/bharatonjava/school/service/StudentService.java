package com.bharatonjava.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.school.dao.GradeDao;
import com.bharatonjava.school.dao.StudentDao;
import com.bharatonjava.school.domain.Grade;
import com.bharatonjava.school.domain.Student;

public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private GradeDao gradeDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public void setGradeDao(GradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}

	@Transactional
	public void saveStudent(Student student) {
		studentDao.saveStudent(student);
	}
	
	@Transactional
	public List<Student> getAllStudents(){
		return studentDao.getAllStudents();
	}
	
	@Transactional
	public List<Grade> getAllGrades(){
		
		return gradeDao.getAllGrades();
	}
}
