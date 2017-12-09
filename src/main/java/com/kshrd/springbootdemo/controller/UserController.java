package com.kshrd.springbootdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kshrd.springbootdemo.model.User;
import com.kshrd.springbootdemo.service.FileUploadService;
import com.kshrd.springbootdemo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@GetMapping(value = {"/", "/user"}) // = @RequestMapping(value = "/user")
	public String userPage(Model model){
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "user/user";
	}
	
	@GetMapping("/user/{id}") //@RequestMapping(value="/user/{id}")
	public String userDetail(@PathVariable("id") Integer id, Model model){
		User user = userService.searchById(id);
		model.addAttribute("userdetail", user);
		return "user/user-detail";
	}
		
	@GetMapping("/user/add") //@RequestMapping(value = "/user/add")
	public String userAddPage(Model model){
		model.addAttribute("addStatus", true);
		model.addAttribute("user", new User());
		return "user/adduser";
	}
	
	@PostMapping("/user/add")// = @RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String actionAddUser(@RequestParam("file") MultipartFile file, Model model, 
								@Valid User user, BindingResult result){
		if(result.hasErrors()){
			for(FieldError error: result.getFieldErrors()){
				System.out.println(error.getField() +": "+ error.getDefaultMessage());
			}
			model.addAttribute("addStatus", true);
			model.addAttribute("user", user);
			return "/user/adduser"; 
		}
		System.out.println("file: " + file.getOriginalFilename());
		String filePath = fileUploadService.upload(file);
		user.setImage(filePath);
		
		System.out.println(user);
		userService.createUser(user);
		return "redirect:/user";	
	}
	
	@DeleteMapping("/user/remove") //@RequestMapping(value = "/user/remove", method = RequestMethod.POST)
	public String removeUser(@RequestParam("id") Integer id){
		System.out.println("Id: " + id);
		userService.removeUser(id);
		return "redirect:/user";
	}
	
	@GetMapping("/user/edit") //@RequestMapping(value = "/user/edit")
	public String editUser(Model model, @RequestParam("id") Integer id){
		System.out.println("Id: " + id);
		User user = userService.searchById(id);
		model.addAttribute("user", user);
		model.addAttribute("addStatus", false);
		return "user/adduser";
	}
	
	@PostMapping("/user/update") //@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public String updateUser(@RequestParam("file") MultipartFile file, 
						Model model, @Valid User user, BindingResult result){
		if(result.hasErrors()){
			for(FieldError error: result.getFieldErrors()){
				System.out.println(error.getField() +": "+ error.getDefaultMessage());
			}
			model.addAttribute("addStatus", false);
			model.addAttribute("user", user);
			return "/user/adduser";
		}
		
		if(!file.isEmpty()){
			System.out.println("file: " + file.getOriginalFilename());
			String filePath = fileUploadService.upload(file);
			user.setImage(filePath);
		}
		
		System.out.println(user);
		userService.updateUser(user);
		return "redirect:/user";
	}
	
}
