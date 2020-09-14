package com.manit.ems.util;

public class CustomCreateResponse {
	private String comments;
	private int id;
	
	CustomCreateResponse(){}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CustomCreateResponse(String comments, int id) {
		super();
		this.comments = comments;
		this.id = id;
	}

	@Override
	public String toString() {
		return "CustomCreateResponse [comments=" + comments + ", id=" + id + "]";
	}

}
