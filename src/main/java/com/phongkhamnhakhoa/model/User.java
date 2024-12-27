package com.phongkhamnhakhoa.model;


import org.springframework.context.annotation.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	
	@Column(nullable = false, length = 64)
	private String password;
	
	public String getPassword() {
		return password;
	}
	@Column(nullable = false, length = 20)
	private String firstName;
	
	private String lastName;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
	
	
	public enum Role {
        Admin, Doctor
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
	
}
