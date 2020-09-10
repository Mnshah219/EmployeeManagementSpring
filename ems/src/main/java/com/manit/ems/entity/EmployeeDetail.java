package com.manit.ems.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee_company_details",schema="public")
public class EmployeeDetail {
	
	@Id
	@Column(name = "e_id")
	@JsonIgnore
	private int eId;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "salary")
	private long salary;
	
	@Column(name = "joining_date")
	private Date joiningDate;
	
	@Column(name = "leaving_date")
	private Date leavingDate;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "e_id")
	@JsonIgnore
	private Employee employee;
	
	public EmployeeDetail() {}
	
	

	public EmployeeDetail(int eId, String department, String designation, long salary, Date joiningDate,
			Date leavingDate, Employee employee) {
		super();
		this.eId = eId;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.leavingDate = leavingDate;
		this.employee = employee;
	}



	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
		
	}

	@Override
	public String toString() {
		return "EmployeeDetail [eId=" + eId + ", department=" + department + ", designation=" + designation
				+ ", salary=" + salary + ", joiningDate=" + joiningDate + ", leavingDate=" + leavingDate + "]";
	}
}
	