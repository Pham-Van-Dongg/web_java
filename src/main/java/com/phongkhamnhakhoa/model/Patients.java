package com.phongkhamnhakhoa.model;

import java.util.Date;
import jakarta.persistence.TemporalType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
@Entity
@Table(name = "patients")
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Khóa chính với giá trị tự động tăng
    private Long id;

    @Column(name = "name_id", nullable = false, length = 20)
    private String name_id;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "phone", length = 15)
    private String phone;
    
    @Column(name = "address", length = 255)
    private String address;

	public Patients(Long id, String name_id, Date birthDate, String phone, String address) {
		super();
		this.id = id;
		this.name_id = name_id;
		this.birthDate = birthDate;
		this.phone = phone;
		this.address = address;
	}

	public Patients() {
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName_id() {
		return name_id;
	}

	public void setName_id(String name_id) {
		this.name_id = name_id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    
}
