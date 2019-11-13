package com.devglan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.dao.EducationDao;
import com.devglan.dao.EducationDao1;
import com.devglan.model.Education;
import com.devglan.model.Education1;
import com.devglan.service.EducationService;
import com.devglan.service.EducationService1;

@Service
public class EducationServiceImpl1 implements EducationService1 {
	@Autowired
	private EducationDao1 educationDao1;

	@Override
	public Education1 save(Education1 educaiton) {
		// TODO Auto-generated method stub
		return educationDao1.save(educaiton);
	}

	@Override
	public List<Education1> findAll1() {
		// TODO Auto-generated method stub
		return educationDao1.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Education1 findOne(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Education1 findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Education1 update(Education1 educaiton) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
