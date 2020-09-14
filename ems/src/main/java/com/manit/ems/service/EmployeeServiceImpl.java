package com.manit.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manit.ems.dao.EmployeeDAO;
import com.manit.ems.entity.Employee;
import com.manit.ems.error.CustomException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(id);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		if(!validateNewEmployee(employee))
			throw new CustomException("Bad request/data");
		employee.setFname(employee.getFname().strip());
		employee.setLname(employee.getLname().strip());
	   employeeDAO.updateEmployee(employee);
		

	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		employeeDAO.deleteEmployee(id);

	}

	@Override
	@Transactional
	public int createEmployee(Employee employee) {
		System.out.println(employee);
		if (!validateNewEmployee(employee))
		{
			throw new CustomException("Invalid request/data");
		}
		else
		{
			employee.setFname(employee.getFname().strip());
			employee.setLname(employee.getLname().strip());
		   return employeeDAO.createEmployee(employee);
			
		}
		
		
	}
	
	private boolean validateNewEmployee(Employee employee) {
		boolean isValid = true;
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	   if( employee.getEmail()==null || employee.getEmail()=="" || !employee.getEmail().matches(regex))
			isValid = false;
	   else if(employee.getPassword() == null || employee.getPassword()=="")
		   isValid = false;
			
		return isValid;
		
	}

}
