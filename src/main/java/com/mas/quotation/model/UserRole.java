package com.mas.quotation.model;

public class UserRole {
	private String username;
	private String role;
	
	public UserRole(String userName, String role) {
		this.username = userName;
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
