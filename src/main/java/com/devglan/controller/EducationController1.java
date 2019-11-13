package com.devglan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.model.ApiResponse;
import com.devglan.model.Education;
import com.devglan.model.Education1;
import com.devglan.service.EducationService1;

@RestController
@RequestMapping("/Education1")
public class EducationController1 {

	@Autowired
	private EducationService1 educationService;

	@PostMapping("/save")
	public ApiResponse<Education> saveUser(@RequestBody Education1 education) {
		System.out.println("save");
		return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.", educationService.save(education));
	}

	@GetMapping("/getAll")
	
	public ApiResponse<List<Education1>> listUser() {
		System.out.println("getAll");
		return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", educationService.findAll1());
	}

}
