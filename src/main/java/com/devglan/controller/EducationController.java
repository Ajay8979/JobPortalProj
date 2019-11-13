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
import com.devglan.service.EducationService;

@RestController
@RequestMapping("/Education")
public class EducationController {

	@Autowired
	private EducationService educationService;
	
	  @PostMapping("/save")
	    public ApiResponse<Education> saveUser(@RequestBody Education education){
	    	System.out.println("save");
	        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",educationService.save(education));
	    }
	    @GetMapping("/getAll")
		public ApiResponse<List<Education>> listUser() 
		{
			System.out.println("getAll");
			return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", educationService.findAll());
		}
	
}
