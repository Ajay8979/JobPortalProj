package com.devglan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Education1_tab")
public class Education1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String specialization;
	private String institute;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cid")
	private CommonEducationDetails commonEducationDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public CommonEducationDetails getCommonEducationDetails() {
		return commonEducationDetails;
	}

	public void setCommonEducationDetails(CommonEducationDetails commonEducationDetails) {
		this.commonEducationDetails = commonEducationDetails;
	}

}
