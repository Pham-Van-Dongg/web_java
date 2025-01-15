package com.phongkhamnhakhoa.model;

import java.time.LocalTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.phongkhamnhakhoa.model.Services;
@Entity
@Table(name ="appointments")
public class Appointments {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) // Khóa chính với giá trị tự động tăng
	 private Long id;
	 private String mahoadon;
	 private String name;
	 private String doctor;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date appointment_date;
	 private LocalTime appointment_time;
	 private Long service_id;
	 
	 @ManyToOne
	 @JoinColumn(name = "service_id", referencedColumnName = "id", insertable = false, updatable = false)
	  private Services service;  // dịch vụ nha khoa
	 
	
	public Appointments() {
		
	}


	public Appointments(Long id, String mahoadon, String name, String doctor, Date appointment_date,
			LocalTime appointment_time, Long service_id, Services service) {
		super();
		this.id = id;
		this.mahoadon = mahoadon;
		this.name = name;
		this.doctor = doctor;
		this.appointment_date = appointment_date;
		this.appointment_time = appointment_time;
		this.service_id = service_id;
		this.service = service;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMahoadon() {
		return mahoadon;
	}


	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDoctor() {
		return doctor;
	}


	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}


	public Date getAppointment_date() {
		return appointment_date;
	}


	public void setAppointment_date(Date appointment_date) {
		this.appointment_date = appointment_date;
	}


	public LocalTime getAppointment_time() {
		return appointment_time;
	}


	public void setAppointment_time(LocalTime appointment_time) {
		this.appointment_time = appointment_time;
	}


	public Long getService_id() {
		return service_id;
	}


	public void setService_id(Long service_id) {
		this.service_id = service_id;
	}


	public Services getService() {
		return service;
	}


	public void setService(Services service) {
		this.service = service;
	}


	
	
}
