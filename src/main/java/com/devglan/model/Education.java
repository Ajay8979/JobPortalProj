package com.devglan.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fresher")
public class Education implements Serializable {
	private static final long serialVersionUID = 8342522725429839302L;
	@Id
	@GeneratedValue
	private Long id;
	private String board;
	private String medium;
	private double percentage;
	private String skills;
	private String yearOfPassing;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "c_id")
	private CommonEducationDetails commonEducationDetails;

	public CommonEducationDetails getCommonEducationDetails() {
		return commonEducationDetails;
	}

	public void setCommonEducationDetails(CommonEducationDetails commonEducationDetails) {
		this.commonEducationDetails = commonEducationDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(String yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
