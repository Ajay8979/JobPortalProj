package com.devglan.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.model.ApiResponse;
import com.devglan.model.SearchJob;
import com.devglan.service.SearchJobService;

@RestController
@RequestMapping("/Search")
public class SearchJobController {
	@Autowired
	private SearchJobService jobService;

	@PostMapping("/save")
	public ApiResponse<SearchJob> saveUser(@RequestBody SearchJob education) {
		System.out.println("save");
		return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.", jobService.save(education));
	}

	@GetMapping("/getAll")
	public ApiResponse<List<SearchJob>> listUser() {
		System.out.println("getAll");
		return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", jobService.findAll1());
	}

	@GetMapping("/find/{skill}/{location}/{experience}")
	public ApiResponse<SearchJob> findBySkilll(@PathVariable(value = "skill") String skill,
			@PathVariable(value = "location") String location, @PathVariable(value = "experience") String experience) {

		List<SearchJob> findBySkill = jobService.findBySkill(skill, location, experience);
		return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", findBySkill);

	}

	@GetMapping("/find1/{company}/{location}/{experience}")
	public ApiResponse<SearchJob> findByCompany(@PathVariable(value = "company") String company,
			@PathVariable(value = "location") String location, @PathVariable(value = "experience") String experience) {

		List<SearchJob> findBySkill1 = jobService.findByCompany(company, location, experience);
		return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", findBySkill1);

	}

	@GetMapping("/find2/{job}/{location}/{experience}")
	public ApiResponse<SearchJob> findByJob(@PathVariable(value = "job") String job,
			@PathVariable(value = "location") String location, @PathVariable(value = "experience") String experience) {

		List<SearchJob> findBySkill2 = jobService.findByJob(job, location, experience);
		return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", findBySkill2);

	}

}
