package com.kshrd.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kshrd.springbootdemo.model.User;
import com.kshrd.springbootdemo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user") // = @RequestMapping(value = "/user")
	public String userPage(Model model){
		
		List<User> users = userService.findAll();
		
		model.addAttribute("users", users);
		return "user/user";
	}
	
	@GetMapping("/user/{id}") //@RequestMapping(value="/user/{id}")
	public String userDetail(@PathVariable("id") Integer id, Model model){
		User user = userService.findById(id);
		model.addAttribute("userdetail", user);
		return "user/userdetail";
	}
		
	@GetMapping("/user/add") //@RequestMapping(value = "/user/add")
	public String userAddPage(Model model){
		model.addAttribute("addStatus", true);
		model.addAttribute("user", new User());
		return "user/adduser";
	}
	
	@PostMapping("/user/add")// = @RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String actionAddUser(User user){
		System.out.println(user);
		userService.save(user);
		return "redirect:/user";	
	}
	
	@PostMapping("/user/remove") //@RequestMapping(value = "/user/remove", method = RequestMethod.POST)
	public String removeUser(@RequestParam("id") Integer id){
		System.out.println("Id: " + id);
		userService.remove(id);
		return "redirect:/user";
	}
	
	@GetMapping("/user/edit") //@RequestMapping(value = "/user/edit")
	public String editUser(Model model, @RequestParam("id") Integer id){
		System.out.println("Id: " + id);
		User user = userService.findById(id);
		model.addAttribute("user", user);
		model.addAttribute("addStatus", false);
		return "user/adduser";
	}
	
	@PostMapping("/user/update") //@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public String updateUser(User user){
		System.out.println(user);
		userService.update(user);
		return "redirect:/user";
	}
}
