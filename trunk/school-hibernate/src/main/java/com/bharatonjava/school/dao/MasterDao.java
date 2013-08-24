package com.bharatonjava.school.dao;

import java.util.List;

import com.bharatonjava.school.domain.Grade;

public interface MasterDao {

	public void createGrade(Grade grade);
	
	public List<Grade> getAllGrades();
	
	public void deleteGrade(Long gradeId);
}
