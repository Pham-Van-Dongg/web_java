package com.phongkhamnhakhoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.phongkhamnhakhoa.model.Patients;

public interface PatientsRepository extends JpaRepository<Patients, Long> {
	

}
