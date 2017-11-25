package com.kshrd.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.kshrd.springbootdemo.model.User;
import com.kshrd.springbootdemo.service.UserService;

@SpringBootApplication
/*@EnableAutoConfiguration
@Configuration
@ComponentScan*/
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
		
		
		UserService userService = context.getBean(UserService.class);
		
		/*userService.findAll().forEach(user->{
			System.out.println(user);
		});*/

		/*User user = new User(11, "Dara", "Male", "Dara.jpg");		
		userService.save(user);
		*/
		/*userService.remove(1);
		
		userService.findAll().forEach(u->{
			System.out.println(u);
		});
		*/
		
	}
}
