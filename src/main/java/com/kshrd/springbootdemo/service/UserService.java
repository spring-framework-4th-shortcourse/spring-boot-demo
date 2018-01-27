package com.kshrd.springbootdemo.service;

import java.util.List;

import com.kshrd.springbootdemo.model.User;
import com.kshrd.springbootdemo.utility.Paging;

public interface UserService {

	public User searchById(Integer id);

	public boolean createUser(User user);

	public boolean removeUser(Integer id);

	public boolean updateUser(User user);
	
	public List<User> findWithPagination(Paging paging);
	
}
