package com.manit.ems.dao;

import java.util.List;

import com.manit.ems.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();
	public Employee getEmployee(int id);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(int id);
	public void createEmployee(Employee employee);
	public Employee getEmployeeByEmail(String email);
	
}
