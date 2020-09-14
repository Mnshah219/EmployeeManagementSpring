package com.manit.ems.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manit.ems.entity.Employee;
import com.manit.ems.error.CustomException;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getEmployees() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee");
		List<Employee> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public Employee getEmployee(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		try {
			employee.getEmployeeDetail().seteId(employee.getId());
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
		}
		catch(Exception e) {
		throw new CustomException("Error updating employee");
		}
	}

	@Override
	public void deleteEmployee(int empId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("delete from EmployeeDetail where eId = :empId");
		query.setParameter("empId", empId);
		query.executeUpdate();
	    query = currentSession.createQuery("delete from Employee where id = :empId");
		query.setParameter("empId", empId);
		
		if(query.executeUpdate()==0)
			throw new CustomException("No such user found");
	}

	@Override
	public int createEmployee(Employee employee) {
		try {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(employee);
		return employee.getId();
		}
		catch(Exception e) {
			if(e.getClass().toString().toLowerCase().contains("constraint"))
				throw new CustomException("Email id is taken.Please select new Email id.");
			else
				throw new CustomException("Error creating user");
		}
	}

	@Override
	public Employee getEmployeeByEmail(String myEmail) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee where email = :myEmail");
		query.setParameter("myEmail", myEmail);
		List<Employee> employeeList = query.getResultList();
		if(employeeList.size()==0) {
		return null;
	}
		else {
			return employeeList.get(0);
		}
	}
}
