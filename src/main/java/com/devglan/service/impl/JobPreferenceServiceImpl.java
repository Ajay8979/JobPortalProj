package com.devglan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.dao.JobPreferenceDao;
import com.devglan.model.JobPreferences;
import com.devglan.service.JobPreferenceService;
@Service
public class JobPreferenceServiceImpl implements JobPreferenceService{
	@Autowired
	private JobPreferenceDao jobPreferenceDao;

	@Override
	public JobPreferences save(JobPreferences educaiton) {
		// TODO Auto-generated method stub
		return jobPreferenceDao.save(educaiton);
	}

	@Override
	public List<JobPreferences> findAll() {
		// TODO Auto-generated method stub
		return jobPreferenceDao.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JobPreferences findOne(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobPreferences findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobPreferences update(JobPreferences educaiton) {
		// TODO Auto-generated method stub
		return null;
	}

}
