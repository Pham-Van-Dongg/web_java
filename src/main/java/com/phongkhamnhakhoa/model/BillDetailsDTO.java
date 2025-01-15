package com.phongkhamnhakhoa.model;

import java.math.BigDecimal;
import java.util.Date;

public class BillDetailsDTO {
    private Long billId;
    private String appointmentId;
    private String patientName;
    private Date appointmentDate;
    private String doctor;
    private String serviceName;
    private BigDecimal servicePrice;

    // Constructor, Getters, Setters
    public BillDetailsDTO(Long billId, String appointmentId, String patientName, Date appointmentDate, 
                          String doctor, String serviceName, BigDecimal servicePrice) {
        this.billId = billId;
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
    }

    // Getters and Setters
    public BillDetailsDTO() {}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
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

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public BigDecimal getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(BigDecimal servicePrice) {
		this.servicePrice = servicePrice;
	}
    
    
}