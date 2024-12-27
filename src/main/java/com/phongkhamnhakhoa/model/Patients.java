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

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "email", unique = true, length = 45)
    private String email;

    @Column(name = "address", length = 255)
    private String address;

    // Getters và setters để thao tác dữ liệu
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
