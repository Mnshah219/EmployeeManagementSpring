package com.manit.ems.auth;

public class AuthenticationRequest {

	private String userName;
	private String password;
	
	public AuthenticationRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
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

	@Override
	public String toString() {
		return "AuthenticationRequest [userName=" + userName + ", password=" + password + ", role="  + "]";
	}
	
	
	
	
	
}
