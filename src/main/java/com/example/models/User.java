package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user" )
public class User {
	
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long userId;
    
    @Column(name = "userName", nullable = false)
    private String email;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "firstName", nullable = true)
    private String firstName;
    
    @Column(name = "lastName", nullable = true)
    private String lastName;
 
    public User(Long userId, String userName, String encrytedPassword) {
        this.userId = userId;
        this.email = userName;
        this.password = encrytedPassword;
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
}