package com.devglan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.dao.EducationDao;
import com.devglan.model.Education;
import com.devglan.service.EducationService;

@Service
public class EducationServiceImpl implements EducationService {
	@Autowired
	private EducationDao educationService;

	@Override
	public Education save(Education educaiton) {
		// TODO Auto-generated method stub
		return educationService.save(educaiton);
	}

	@Override
	public List<Education> findAll() {
		// TODO Auto-generated method stub
		return educationService.findAll();
	}

	@Override
	public void delete(int id) {
		educationService.deleteById((long) id);
		
	}

	@Override
	public Education findOne(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Education findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Education update(Education educaiton) {
		// TODO Auto-generated method stub
		return null;
	}

}
