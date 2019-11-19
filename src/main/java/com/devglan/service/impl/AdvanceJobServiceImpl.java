package com.devglan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.dao.AdvanceJobDao;
import com.devglan.model.AdvanceJobSearch;
import com.devglan.service.AdvanceJobService;

@Service
public class AdvanceJobServiceImpl implements AdvanceJobService {

	@Autowired
	private AdvanceJobDao advanceJobDao;

	@Override
	public AdvanceJobSearch save(AdvanceJobSearch educaiton) {
		// TODO Auto-generated method stub
		return advanceJobDao.save(educaiton);
	}

	@Override
	public List<AdvanceJobSearch> findAll() {
		// TODO Auto-generated method stub
		return advanceJobDao.findAll();
	}

}
