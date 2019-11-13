package com.devglan.service;

import java.util.List;

import com.devglan.model.JobPreferences;

public interface JobPreferenceService {

	JobPreferences save(JobPreferences educaiton);
    List<JobPreferences> findAll();
    void delete(int id);

    JobPreferences findOne(String username);

    JobPreferences findById(int id);

    JobPreferences update(JobPreferences educaiton);
    
}
