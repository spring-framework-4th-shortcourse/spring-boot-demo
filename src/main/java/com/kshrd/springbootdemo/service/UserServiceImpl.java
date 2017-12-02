package com.kshrd.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.springbootdemo.model.User;
import com.kshrd.springbootdemo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User searchById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public void createUser(User user) {
		boolean status = userRepository.save(user);
		if (status)
			System.out.println("-> Added Successfully!");
		else
			System.out.println("-> Added Fail!");
	}

	@Override
	public void removeUser(Integer id) {
		if (userRepository.remove(id))
			System.out.println("-> Removed Successfully!");
		else
			System.out.println("-> Remove Fail!");
	}

	@Override
	public void updateUser(User user) {
		if (userRepository.update(user))
			System.out.println("-> Updated Successfully!");
		else
			System.out.println("-> Update Fail!");
	}

}
