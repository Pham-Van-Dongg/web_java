package com.phongkhamnhakhoa.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PatientsDto {
	
	@NotEmpty(message = "Tên họ không được để trống")
	@Column(name = "name_id", nullable = false, length = 255)
	private String name_id;
	
	@NotNull(message = "Ngày sinh không được để trống")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;
	
	@NotEmpty(message = "Điện thoại không được để trống")
	@Column(name = "phone", length = 15)
	private String phone;
	
	@Column(name = "address", length = 255)
	@NotEmpty(message = "Địa chỉ không được để trống")
	private String address;

	public PatientsDto(@NotEmpty(message = "Tên họ không được để trống") String name_id,
			@NotNull(message = "Ngày sinh không được để trống") Date birthDate,
			@NotEmpty(message = "Điện thoại không được để trống") String phone,
			@NotEmpty(message = "Địa chỉ không được để trống") String address) {
		super();
		this.name_id = name_id;
		this.birthDate = birthDate;
		this.phone = phone;
		this.address = address;
	}

	public PatientsDto() {
		
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
