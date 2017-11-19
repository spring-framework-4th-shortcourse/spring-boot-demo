package com.kshrd.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kshrd.springbootdemo.model.User;

@Controller
public class HelloWorldController {

	@RequestMapping(value = {"/", "/home", "/index"})
	public String indexPage(Model model){
		System.out.println("Hello");
		model.addAttribute("message", "Hello World!!!!");
		
		User user = new User(100, "Dara", "Male", "Dara.jpg");
		model.addAttribute("user", user);
		
		model.addAttribute("text", "<b>Hi!!</b>");
		
		return "index";
	}
	
	@RequestMapping("/about")
	public String aboutPage(){
		System.out.println("About");
		return "about";
	}
	
	@ResponseBody
	@RequestMapping("/test")
	public String test(){
		return "Hello World!";
	}
	
	/*@ResponseBody
	@RequestMapping("/user")  // /user?name=Dara
	public String home(@RequestParam(name = "name", required=false, defaultValue="Default") String name){
		System.out.println(name);
		return name;
	}*/
	
	/*@ResponseBody
	@RequestMapping("/user/{name}")  
	public String home(@PathVariable("name") String name){
		System.out.println(name);
		return name;
	}*/
	
}
