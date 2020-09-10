package com.manit.ems.auth;

public class AuthenticationRequest {

	private String userName;
	private String password;
	private String role;
	
	public AuthenticationRequest(String userName, String password, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	
	public AuthenticationRequest() {}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AuthenticationRequest [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
	
}
