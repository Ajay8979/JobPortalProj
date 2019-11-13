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
import com.devglan.model.JobPreferences;
import com.devglan.service.JobPreferenceService;

@RestController
@RequestMapping("/Job")
public class JobPreferenceController {

	@Autowired
	private JobPreferenceService jobPreferenceService;
	
	  @PostMapping("/save")
	    public ApiResponse<JobPreferences> saveUser(@RequestBody JobPreferences jobPreferences){
	    	System.out.println("save");
	        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",jobPreferenceService.save(jobPreferences));
	    }
	    @GetMapping("/getAll")
		public ApiResponse<List<JobPreferences>> listUser() 
		{
			System.out.println("getAll");
			return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", jobPreferenceService.findAll());
		}
	
}
