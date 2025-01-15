package com.phongkhamnhakhoa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phongkhamnhakhoa.model.Patients;

public interface PatientsRepository extends JpaRepository<Patients, Long> {
	@Query("SELECT p FROM Patients p WHERE p.name_id LIKE %:keyword%")
	Page<Patients> searchByName(@Param("keyword") String keyword, Pageable pageable);
}
