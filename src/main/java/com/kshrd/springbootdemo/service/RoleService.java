package com.kshrd.springbootdemo.service;

import java.util.List;

import com.kshrd.springbootdemo.model.Role;

public interface RoleService {
	public List<Role> getAllRoles();
	public Role getRoleById(Integer id);
}
