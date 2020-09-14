package com.manit.ems.service;
import java.util.List;

import com.manit.ems.entity.Employee;

public interface EmployeeService {
	

		public List<Employee> getEmployees();
		public Employee getEmployee(int id);
		public void updateEmployee(Employee employee);
		public void deleteEmployee(int id);
		public int createEmployee(Employee employee);


}
