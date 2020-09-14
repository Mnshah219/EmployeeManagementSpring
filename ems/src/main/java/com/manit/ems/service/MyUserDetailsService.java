package com.manit.ems.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manit.ems.auth.MyUserDetails;
import com.manit.ems.dao.AdminDAO;
import com.manit.ems.dao.EmployeeDAO;
import com.manit.ems.entity.Admin;
import com.manit.ems.entity.Employee;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	@Transactional
	public MyUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin admin = adminDAO.getAdminByEmail(email);
	    Employee employee = employeeDAO.getEmployeeByEmail(email);
	    ArrayList<GrantedAuthority> arrayList = new ArrayList<>();
	   
	    	
	    	if(admin!=null) {
				arrayList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				arrayList.add(new SimpleGrantedAuthority("ROLE_USER"));
				request.setAttribute("role", "admin");
				return new MyUserDetails(admin.getEmail(), admin.getPassword(), arrayList,admin.geteId());
	    	}
	    	else if(employee!=null) {
	    		arrayList.add(new SimpleGrantedAuthority("ROLE_USER"));
	    		request.setAttribute("role", "user");
				return new MyUserDetails(employee.getEmail(), employee.getPassword(), arrayList,employee.getId());
	    	}
	    	else {
	    		throw new UsernameNotFoundException("User name not found");
	    	}
	    

	}
}
