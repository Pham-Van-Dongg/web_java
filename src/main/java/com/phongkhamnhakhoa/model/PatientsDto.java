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
	@Column(name = "first_name", nullable = false, length = 255)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 255)
	@NotEmpty(message = "Tên chính không được để trống")
	private String lastName;
	
	@NotNull(message = "Ngày sinh không được để trống")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;
	
	@NotEmpty(message = "Điện thoại không được để trống")
	@Column(name = "phone", length = 15)
	private String phone;
	
	@Column(name = "email", unique = true, length = 45)
	@NotEmpty(message = "Email không được để trống")
	private String email;
	
	@Column(name = "address", length = 255)
	@NotEmpty(message = "Địa chỉ không được để trống")
	private String address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
