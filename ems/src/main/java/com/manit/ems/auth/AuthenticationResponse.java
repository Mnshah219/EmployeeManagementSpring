package com.manit.ems.auth;

public class AuthenticationResponse {
	
	private String jwt;
	private String role;
	private long expires;
	public AuthenticationResponse() {}

	

	public AuthenticationResponse(String jwt, String role) {
		super();
		this.jwt = jwt;
		this.role = role;
		this.expires = System.currentTimeMillis() + 9 * 60 * 60 * 1000;
	}



	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public long getExpires() {
		return expires;
	}



	public void setExpires(long expires) {
		this.expires = expires;
	}



	@Override
	public String toString() {
		return "AuthenticationResponse [jwt=" + jwt + ", role=" + role + "]";
	}

	
	

}
