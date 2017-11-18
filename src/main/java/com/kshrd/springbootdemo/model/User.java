package com.kshrd.springbootdemo.model;

public class User {
	private int id;
	private String name;
	private String gender;
	private String image;
	
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

}
