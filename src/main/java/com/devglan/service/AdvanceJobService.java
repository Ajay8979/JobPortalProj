package com.devglan.service;

import java.util.List;

import com.devglan.model.AdvanceJobSearch;

public interface AdvanceJobService {
	AdvanceJobSearch save(AdvanceJobSearch educaiton);
    List<AdvanceJobSearch> findAll();
}
