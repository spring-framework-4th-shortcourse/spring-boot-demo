package com.kshrd.springbootdemo.service;

import java.util.List;

import com.kshrd.springbootdemo.model.User;

public interface UserService {

	public List<User> findAllUsers();

	public User searchById(Integer id);

	public void createUser(User user);

	public void removeUser(Integer id);

	public void updateUser(User user);
}
