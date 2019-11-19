package com.devglan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="advance")
public class AdvanceJobSearch{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String keySkill;
	private String locations;
	private String year;
	private String month;
	private long salry;
	private String[] industry;
	private String function;

	public AdvanceJobSearch() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeySkill() {
		return keySkill;
	}

	public void setKeySkill(String keySkill) {
		this.keySkill = keySkill;
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public long getSalry() {
		return salry;
	}

	public void setSalry(long salry) {
		this.salry = salry;
	}

	public String[] getIndustry() {
		return industry;
	}

	public void setIndustry(String[] industry) {
		this.industry = industry;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	

}
