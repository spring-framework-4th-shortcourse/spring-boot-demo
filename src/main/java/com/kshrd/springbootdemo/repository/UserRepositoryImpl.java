package com.kshrd.springbootdemo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.kshrd.springbootdemo.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private List<User> users = new ArrayList<>();

	public UserRepositoryImpl() {
		Faker faker = new Faker();
		for (int i = 0; i < 10; i++) {
			String name = faker.name().fullName();
			String image = faker.internet().image(100, 100, false, null);
			User user = new User(i + 1, name, (i > 5) ? "M" : "F", image);
			users.add(user);
		}
	}

	@Override
	public List<User> findAll() {
		return users;
	}

	@Override
	public User findById(Integer id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	@Override
	public boolean save(User user) {
		return users.add(user);
	}

	@Override
	public boolean remove(Integer id) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				users.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == user.getId()) {
				users.set(i, user);
				return true;
			}
		}
		return false;
	}
}
