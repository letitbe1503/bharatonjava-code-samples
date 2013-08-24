package com.bharatonjava.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.school.dao.MasterDao;
import com.bharatonjava.school.domain.Grade;

@Service
public class MasterService {

	@Autowired
	private MasterDao masterDao;

	public MasterService() {
	}

	public void setMasterDao(MasterDao masterDao) {
		this.masterDao = masterDao;
	}
	
	@Transactional
	public void createGrade(Grade grade){
		masterDao.createGrade(grade);
	}

	@Transactional
	public List<Grade> getAllGrades(){
		return masterDao.getAllGrades();
	}
	
	@Transactional
	public void deleteGrade(Long gradeId){
		masterDao.deleteGrade(gradeId);
	}
}
