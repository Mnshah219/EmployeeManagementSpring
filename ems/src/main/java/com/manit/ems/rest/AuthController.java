package com.manit.ems.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manit.ems.auth.AuthenticationRequest;
import com.manit.ems.auth.AuthenticationResponse;
import com.manit.ems.auth.MyUserDetails;
import com.manit.ems.dao.EmployeeDAO;
import com.manit.ems.error.CustomException;
import com.manit.ems.service.MyUserDetailsService;
import com.manit.ems.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	private MyUserDetailsService myUserDetailService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	EmployeeDAO employeeDAO;
	@PostMapping("/authenticate")
	public ResponseEntity<?> loginEmployee(@RequestBody AuthenticationRequest authRequest,HttpServletRequest request) {
		try {
			request.setAttribute("role", authRequest.getRole());
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		}
		catch(BadCredentialsException e) {
			throw new CustomException("Incorrect usrname or password");
		}
		
		final MyUserDetails myUserDetails = myUserDetailService.loadUserByUsername(authRequest.getUserName());
		
		final String jwt = jwtUtil.generateToken(myUserDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		//TODO add appropriate return types and response + password encrypted from frontend
		
	}
}
