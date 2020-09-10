package com.manit.ems.util;

public class CustomResponseMessage {
	
	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "CustomResponseMessage [comment=" + comment + "]";
	}

	public CustomResponseMessage(String comment) {
		super();
		this.comment = comment;
	}
	public CustomResponseMessage() {}

}
