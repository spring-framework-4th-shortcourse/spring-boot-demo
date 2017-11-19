package com.kshrd.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kshrd.springbootdemo.model.User;
import com.kshrd.springbootdemo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user")
	public String userPage(Model model){
		
		List<User> users = userService.findAll();
		
		model.addAttribute("users", users);
		return "user";
	}
	
	@RequestMapping(value="/user/{id}")
	public String userDetail(@PathVariable("id") Integer id, Model model){
		User user = userService.findById(id);
		model.addAttribute("userdetail", user);
		return "userdetail";
	}
	
	
	
}
