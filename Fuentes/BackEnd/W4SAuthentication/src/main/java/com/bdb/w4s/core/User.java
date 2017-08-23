package com.bdb.w4s.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String full_Name;

    private String email;
    
    @Column(name = "phone_Number")
    private String phoneNumber;
    
    @Column(name = "image_Path")
    private String imagePath;
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getphoneNumber() {
		return phoneNumber;
	}

	public void setphoneNumber(String name) {
		this.phoneNumber = name;
	}
	
	public String getName() {
		return full_Name;
	}

	public void setName(String name) {
		this.full_Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
    
    
}

