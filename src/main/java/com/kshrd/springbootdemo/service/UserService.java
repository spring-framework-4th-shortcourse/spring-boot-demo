package com.kshrd.springbootdemo.service;

import java.util.List;

import com.kshrd.springbootdemo.model.User;

public interface UserService {
	
	public List<User> findAll();
	public User findById(Integer id);
	public void save(User user);
	public void remove(Integer id);
	public void update(User user);
}
