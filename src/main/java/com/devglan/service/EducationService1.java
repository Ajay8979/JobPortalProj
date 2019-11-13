package com.devglan.service;

import java.util.List;

import com.devglan.model.Education1;

public interface EducationService1 {

	Education1 save(Education1 educaiton);

	List<Education1> findAll1();

	void delete(int id);

	Education1 findOne(String username);

	Education1 findById(int id);

	Education1 update(Education1 educaiton);

}
