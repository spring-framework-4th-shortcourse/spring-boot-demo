package com.kshrd.springbootdemo.model;

public class Role {

	private int id;
	private String role;

	
	public Role(int id) {
		super();
		this.id = id;
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	public Role() {
		super();
	}

	public Role(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	}
}
