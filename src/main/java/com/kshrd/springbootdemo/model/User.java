package com.kshrd.springbootdemo.model;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	private int id;

	@NotEmpty(message = "User name cannot be empty!")
	@Size(min = 10, max = 30, message = "User name must be between {2} and {1} characters!")
	private String name;

	@Size(min = 1, max = 1, message = "Gender must be one character long!")
	private String gender;

	//@NotEmpty(message = "Image can't be empty!")
	private String image;
	
	private List<Role> roles;
	
	public User() {
	}

	public User(int id, String name, String gender, String image) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", image=" + image + "]";
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
