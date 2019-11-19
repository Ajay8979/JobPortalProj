package com.devglan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.dao.SearchJobDao;
import com.devglan.model.SearchJob;
import com.devglan.service.SearchJobService;
@Service
public class SearchJobImpl  implements SearchJobService{
@Autowired
private SearchJobDao searchJobDao;
	
	
	@Override
	public SearchJob save(SearchJob educaiton) {
		// TODO Auto-generated method stub
		return searchJobDao.save(educaiton);
	}

	@Override
	public List<SearchJob> findAll1() {
		// TODO Auto-generated method stub
		return searchJobDao.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SearchJob findOne(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchJob findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchJob update(SearchJob educaiton) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<SearchJob> findBySkill(String skill, String location, String experience) {
		// TODO Auto-generated method stub
		return searchJobDao.findBySkill(skill, location, experience) ;
	}

	@Override
	public List<SearchJob> findByCompany(String company, String location, String experience) {
		// TODO Auto-generated method stub
		return searchJobDao.findByCompany(company, location, experience);
	}

	@Override
	public List<SearchJob> findByJob(String job, String location, String experience) {
		// TODO Auto-generated method stub
		return searchJobDao.findByJob(job, location, experience);
	}

}
