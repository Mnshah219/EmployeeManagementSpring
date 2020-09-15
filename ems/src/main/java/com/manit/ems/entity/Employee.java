package com.manit.ems.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "employee_personal_details",schema="public")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "fname")
	private String fname;
	
	@Column(name = "lname")
	private String lname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gender")
	private boolean gender;
	
	@Column(name = "dob")
	private Date dob;
	@Column(name="password")
	private String password;
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
	private EmployeeDetail  employeeDetail;
	
	public Employee() {}
	
	

	public Employee(int id, String fname, String lname, String email, boolean gender, Date dob,
			EmployeeDetail employeeDetail) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.employeeDetail = employeeDetail;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		if(employeeDetail == null) {
			if(this.employeeDetail != null) {
				this.employeeDetail.setEmployee(null);
			}
		}
		else {
			employeeDetail.setEmployee(this);
		}
		this.employeeDetail = employeeDetail;
	}
	
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", gender="
				+ gender + ", age=" + dob + ", password=" + password + ", employeeDetail=" + employeeDetail + "]";
	}



	

	
	
	
	
	

}
