package com.devglan.service;

import java.util.List;

import com.devglan.model.Education;

public interface EducationService {

	Education save(Education educaiton);
    List<Education> findAll();
    void delete(int id);

    Education findOne(String username);

    Education findById(int id);

    Education update(Education educaiton);
    
}
