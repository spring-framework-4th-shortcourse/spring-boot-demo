package com.kshrd.springbootdemo.service;

import java.util.List;

import com.kshrd.springbootdemo.model.User;
import com.kshrd.springbootdemo.utility.Paging;

public interface UserService {

	public User searchById(Integer id);

	public void createUser(User user);

	public void removeUser(Integer id);

	public void updateUser(User user);
	
	public List<User> findWithPagination(Paging paging);
	
}
