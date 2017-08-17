package com.bdb.w4s.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
  
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	private String email;
	
	
	private String fullname;
	
	
	private String phonenumber;
	
	
	public User()
	{
		
	}
	
	protected User(String name, String phone)
	{
		
		
		this.setFullname(name);
		this.setPhonenumber(phone);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
}
