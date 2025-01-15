package com.phongkhamnhakhoa.repository;

import org.springframework.stereotype.Repository;
import com.phongkhamnhakhoa.model.Appointments;
import com.phongkhamnhakhoa.model.Services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface AppointmentsRepository extends JpaRepository<Appointments, Long>{
	 List<Appointments> findByNameContaining(String name);
}
