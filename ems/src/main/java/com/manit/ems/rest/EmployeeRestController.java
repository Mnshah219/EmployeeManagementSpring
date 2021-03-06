package com.manit.ems.rest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manit.ems.entity.Employee;
import com.manit.ems.service.EmployeeService;
import com.manit.ems.util.CustomCreateResponse;
import com.manit.ems.util.CustomResponseMessage;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	@Autowired
	private EmployeeService service;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return service.getEmployees();
	}
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/employee")
		public Employee getEmployee(HttpServletRequest request) {
		int id = Integer.parseInt(request.getAttribute("id").toString()); 
		return service.getEmployee(id);
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/create")
	public ResponseEntity<CustomCreateResponse> createEmployee(@RequestBody Employee employee) {
		
		int id=service.createEmployee(employee);
		return new ResponseEntity<CustomCreateResponse>(new CustomCreateResponse("Employee Created",id),HttpStatus.OK);
		}
	
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CustomResponseMessage> deleteEmployee(@PathVariable("id") int id) {
		String message = "Deletion successfull";
		service.deleteEmployee(id);
		return new ResponseEntity<CustomResponseMessage>(new CustomResponseMessage(message),HttpStatus.OK);
		
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/employee")
	public ResponseEntity<CustomResponseMessage> updateEmployee( @RequestBody Employee employee) {
		System.out.println("--------->"+employee);
		service.updateEmployee(employee);
		return new ResponseEntity<CustomResponseMessage>(new CustomResponseMessage("Employee Updated"),HttpStatus.OK);
	}
	

}
