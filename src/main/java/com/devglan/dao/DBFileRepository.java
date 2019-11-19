package com.devglan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devglan.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}