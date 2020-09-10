package com.manit.ems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin",schema="public")
public class Admin {
	
	@Id
	@GeneratedValue
	@Column(name="e_id")
	private int eId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	public Admin() {}
	
	

	public Admin(int eId, String email, String password) {
		super();
		this.eId = eId;
		this.email = email;
		this.password = password;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
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



	@Override
	public String toString() {
		return "Admin [eId=" + eId + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}
