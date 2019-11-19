package com.devglan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.model.AdvanceJobSearch;
import com.devglan.model.ApiResponse;
import com.devglan.service.AdvanceJobService;

@RestController
@RequestMapping("/Advance")
public class AdvanceJobController {

	@Autowired
	private AdvanceJobService advanceJobService;
	
	@PostMapping("/save")
	public ApiResponse<AdvanceJobSearch> saveUser(@RequestBody AdvanceJobSearch education) {
		return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.", advanceJobService.save(education));
	}

	@GetMapping("/getAll")
	public ApiResponse<List<AdvanceJobSearch>> listUser() {
		return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", advanceJobService.findAll());
	}

	
}
