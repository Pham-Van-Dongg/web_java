package com.phongkhamnhakhoa.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "appointment_id", referencedColumnName = "mahoadon", insertable = false, updatable = false)
    private Appointments appointments;  // Liên kết đến bảng appointments

    // Các trường thông tin khác của Bill
    private String patientName;
    private Date appointmentDate;

    private String appointment_id;
    // Getters and Setters
    public Bills() {
    
    }
	public Bills(Long id, Appointments appointments, String patientName, Date appointmentDate, String appointment_id) {
		super();
		this.id = id;
		this.appointments = appointments;
		this.patientName = patientName;
		this.appointmentDate = appointmentDate;
		this.appointment_id = appointment_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Appointments getAppointments() {
		return appointments;
	}
	public void setAppointments(Appointments appointments) {
		this.appointments = appointments;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(String appointment_id) {
		this.appointment_id = appointment_id;
	}

	// Lấy thông tin dịch vụ từ Appointment
    public Services getService() {
        return appointments != null ? appointments.getService() : null;
    }
    
}
