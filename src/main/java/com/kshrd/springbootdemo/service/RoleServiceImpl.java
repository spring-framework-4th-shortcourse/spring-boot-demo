package com.kshrd.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.springbootdemo.model.Role;
import com.kshrd.springbootdemo.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

}
