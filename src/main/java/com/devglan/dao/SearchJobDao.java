package com.devglan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devglan.model.SearchJob;

public interface SearchJobDao extends JpaRepository<SearchJob, Long> {

	// @Query(value = "SELECT skill,location,experience,job FROM searchjob j WHERE
	// j.skill = ?1 and j.location = ?2 and j.experience=?3", nativeQuery = true)
	// @Query(value="SELECT skill,location,experience FROM searchjob j WHERE j.skill

	// = ?1 and j.location = ?2 and j.experience=?3",nativeQuery=true)
	// public List<SearchJob> findBySkill(@Param(value = "skill") String skill,
	// @Param(value = "location") String location, @Param(value = "location") String
	// experience);

	@Query(value = "SELECT skill, location,experience,job,FROM searchjob j WHERE j.skill = ?1 and j.location = ?2 and j.experience=?3", nativeQuery = true)

	public List<SearchJob> findBySkill(String skill, String location, String experience);
}
