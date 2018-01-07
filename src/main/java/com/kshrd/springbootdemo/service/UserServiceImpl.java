package com.kshrd.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kshrd.springbootdemo.model.Role;
import com.kshrd.springbootdemo.model.User;
import com.kshrd.springbootdemo.repository.MybatisUserRepository;
import com.kshrd.springbootdemo.utility.Paging;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private MybatisUserRepository userRepository;

	@Override
	public User searchById(Integer id) {
		return userRepository.findById(id);
	}
	
	@Transactional
	@Override
	public void createUser(User user) {
		boolean status = userRepository.save(user);
		if (status){
			for(Role role: user.getRoles()){
				userRepository.saveUserRole(user.getId(), role.getId());
			}
			System.out.println("-> Added Successfully!");
		}
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

	@Transactional
	@Override
	public void updateUser(User user) {
		//update user's info
		if (userRepository.update(user)){
			
			//remove all user's role from table tbuser_role
			userRepository.removeUserRoleByUserId(user.getId());

			//add new user's role
			for(Role role: user.getRoles()){
				userRepository.saveUserRole(user.getId(), role.getId());
			}
			System.out.println("-> Updated Successfully!");
		}
		else
			System.out.println("-> Update Fail!");
	}

	@Override
	public List<User> findWithPagination(Paging paging) {
		Integer totalCount = userRepository.countUser();
		paging.setTotalCount(totalCount);
		return userRepository.findWithPagination(paging);
	}

}
