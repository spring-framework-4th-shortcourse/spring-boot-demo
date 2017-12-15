package com.kshrd.springbootdemo;

import com.kshrd.springbootdemo.model.User;
import com.kshrd.springbootdemo.repository.MybatisUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

	@Autowired
	MybatisUserRepository repo;

	@Test
	public void contextLoads() {
		/*for (User user : repo.findAll()) {
			System.out.println(user);
			System.out.println(user.getRoles());
		}*/
		User u = new User();
		u.setName("TEST");
		repo.save(u);
		System.out.println(u);
		System.out.println(u.getId());
	}

}
