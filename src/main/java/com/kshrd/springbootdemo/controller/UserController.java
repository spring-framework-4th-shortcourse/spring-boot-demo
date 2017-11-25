package com.kshrd.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "user/user";
	}
	
	@RequestMapping(value="/user/{id}")
	public String userDetail(@PathVariable("id") Integer id, Model model){
		User user = userService.findById(id);
		model.addAttribute("userdetail", user);
		return "user/userdetail";
	}
		
	@RequestMapping(value = "/user/add")
	public String userAddPage(){
		return "user/adduser";
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String actionAddUser(User user){
		System.out.println(user);
		userService.save(user);
		return "redirect:/user";
	}
	
	@RequestMapping(value = "/user/remove")
	public String removeUser(@RequestParam("id") Integer id){
		System.out.println("Id: " + id);
		userService.remove(id);
		return "redirect:/user";
	}
	
	@RequestMapping(value = "/user/edit")
	public String editUser(Model model, @RequestParam("id") Integer id){
		System.out.println("Id: " + id);
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "user/edituser";
	}
	
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public String updateUser(User user){
		System.out.println(user);
		userService.update(user);
		return "redirect:/user";
	}
}
