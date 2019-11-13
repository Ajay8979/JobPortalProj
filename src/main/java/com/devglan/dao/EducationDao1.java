package com.devglan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devglan.model.Education1;
@Repository
public interface EducationDao1 extends JpaRepository<Education1, Long>{

}
