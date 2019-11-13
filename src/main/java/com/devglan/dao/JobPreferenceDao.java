package com.devglan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devglan.model.JobPreferences;

public interface JobPreferenceDao extends JpaRepository<JobPreferences, Long> {

}
