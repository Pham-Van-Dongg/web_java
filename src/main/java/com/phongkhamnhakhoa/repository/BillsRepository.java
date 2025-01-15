package com.phongkhamnhakhoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phongkhamnhakhoa.model.Bills;

public interface BillsRepository extends JpaRepository<Bills, Long> {
    
    @Query(value = "SELECT b.id AS billId, b.appointment_id AS appointmentId, b.patient_name AS patientName, b.appointment_date AS appointmentDate, " +
             "a.doctor AS doctor, s.name AS serviceName, s.price AS servicePrice " +
             "FROM bills b " +
             "JOIN appointments a ON b.appointment_id = a.mahoadon " +
             "JOIN services s ON a.service_id = s.id " +
             "WHERE b.appointment_id = :appointmentId", nativeQuery = true)
    List<Object[]> findBillDetailsByAppointmentId(@Param("appointmentId") String appointmentId);
    
    @Query("SELECT b FROM Bills b WHERE b.appointment_id LIKE %:query% OR b.patientName LIKE %:query%")
	List<Bills> findByAppointmentIdContainingOrPatientNameContaining(@Param("query") String appointmentId,
	        @Param("query") String patientName);
}
