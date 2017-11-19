package com.kshrd.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kshrd.springbootdemo.model.User;

@Service
public class UserService {
	
	private List<User> users= new ArrayList<>();
	
	public UserService() {
		for(int i=0; i<10; i++){
			User user = new User(i+1, "user-"+ i, (i>5)?"M":"F", "User.JPG");
			users.add(user);
		}
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(Integer id){
		for(User user: users){
			if(user.getId() == id)
				return user;
		}
		return null;
	}
	
}
