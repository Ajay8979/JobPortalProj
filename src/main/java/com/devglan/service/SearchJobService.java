package com.devglan.service;

import java.util.List;

import com.devglan.model.SearchJob;

public interface SearchJobService {
	SearchJob save(SearchJob educaiton);

	List<SearchJob> findAll1();

	void delete(int id);

	SearchJob findOne(String username);

	SearchJob findById(int id);

	SearchJob update(SearchJob educaiton);
	
	public List<SearchJob> findBySkill(String skill, String location, String experience);

}
